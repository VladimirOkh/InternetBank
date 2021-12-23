package com.skillfactory.mvc.demo.controller;

import com.skillfactory.mvc.demo.model.Client;
import com.skillfactory.mvc.demo.model.Operation;
import com.skillfactory.mvc.demo.repository.ClientRepository;
import com.skillfactory.mvc.demo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OperController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OperationRepository operationRepository;


    //Пополнение счета
    @GetMapping("/main/deposit")
    public String getDeposit(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model)
    {


        model.put("client", client);
        return "deposit";
    }
    @PostMapping("/main/deposit")
    public String deposit(
            @AuthenticationPrincipal Client client,
            @RequestParam Integer deposit,
            Map<String, Object> model)
    {

        if ((deposit != null)&&(deposit > 0)) {
            try {
                client.setBalance(client.getBalance() + deposit);
                SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                Date date = new Date();
                Operation oper = new Operation();
                oper.setType("Пополнение");
                oper.setUsername(client.getUsername());
                oper.setDate(formater.format(date));
                oper.setAmount(deposit);
                model.put("message1","Удачно.");
                clientRepository.save(client);
                operationRepository.save(oper);
            }catch (Exception e){
                model.put("message1","Ошибка! Попробуйте еще раз, пожалуйста.");
            }

        }else model.put("message1","Ошибка! Попробуйте еще раз, пожалуйста.");
        model.put("client", client);
        return "deposit";
    }



    //Перевод денег
    @GetMapping("/main/transfer")
    public String getTransfer(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model)
    {


        model.put("client", client);
        return "transfer";
    }
    @PostMapping("/main/transfer")
    public String transfer(
            @AuthenticationPrincipal Client client,
            @RequestParam Integer transfer,
            @RequestParam String username,
            Map<String, Object> model)
    {
        Client client1;


        if ((username != null)&&(transfer!=null)&&(transfer>0)&&(client.getBalance() >= transfer))
        {
            try
            {
                client1 = clientRepository.findByUsername(username);
                if (!(client1.getUsername().equals(client.getUsername())))
                {
                    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    Date date = new Date();
                    Operation send = new Operation();
                    send.setType("Перевод");
                    send.setUsername(client.getUsername());
                    send.setReceiver(client1.getUsername());
                    send.setDate(formater.format(date));
                    send.setAmount(transfer);
                    client1.setBalance(client1.getBalance() + transfer);
                    client.setBalance(client.getBalance() - transfer);
                    operationRepository.save(send);
                    clientRepository.save(client1);
                    clientRepository.save(client);
                    model.put("message2", "Удачно.");

                } else model.put("message2", "Ошибка! Вы не можете перевести деньги самому себе.");
            }
            catch(Exception e) {
                model.put("message2", "Пользователь не найден");
            }
        }else model.put("message2","Ошибка! Пополните баланс и попробуйте еще раз, пожалуйста.");

        model.put("client",client);
        return "transfer";
    }

    //Снятие денег
    @GetMapping("/main/withdraw")
    public String getWithdraw(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model){

        model.put("client", client);
        return "withdraw";
    }
    @PostMapping("/main/withdraw")
    public String withdraw(
            @AuthenticationPrincipal Client client,
            @RequestParam Integer withdraw,
            Map<String, Object> model)
    {

        if ((withdraw != null)&&(withdraw > 0)&&(client.getBalance() >= withdraw)&&(client.getBalance()>0)) {
            client.setBalance(client.getBalance() - withdraw);
            SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date date = new Date();
            Operation oper = new Operation();
            oper.setType("Снятие");
            oper.setUsername(client.getUsername());
            oper.setDate(formater.format(date));
            oper.setAmount(withdraw);
            operationRepository.save(oper);
            clientRepository.save(client);
            model.put("message3","Удачно.");
        }else model.put("message3","Ошибка! Поплните баланс и попробуйте еще раз, пожалуйста.");

        model.put("client", client);
        return "withdraw";
    }

    @GetMapping("/main/operations")
    public String getOperationList(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model){


        List<Operation> operations = operationRepository.findOperationsByUsername(client.getUsername());
        model.put("operations", operations);

        return "operations";
    }
    @PostMapping("/main/operations")
    public String OperationList(
            @AuthenticationPrincipal Client client,
            Map<String, Object> model){


        List<Operation> operations = operationRepository.findOperationsByUsername(client.getUsername());




        model.put("operations", operations);

        return "operations";
    }


}
