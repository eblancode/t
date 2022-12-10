package main.controllers;

import main.dtos.TransactionDTO;
import main.modules.Transaction;
import main.repositories.TransactionRepository;
import main.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionService transactionService;

    @PatchMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transaction makeAccountTransfer(@AuthenticationPrincipal UserDetails userDetails, @RequestBody TransactionDTO transactionDTO){/*@AuthenticationPrincipal UserDetails userDetails,*/
        // todo: if "getuser" is owner of "Account" then transfer an amount to an Account found by ID
        // todo: EXTRA if transfer is succesful add Transfer to account list
        //if (userDetails.getUsername().equals(transactionDTO.se))
        return transactionService.transfer(transactionDTO,userDetails.getUsername());
    }

}