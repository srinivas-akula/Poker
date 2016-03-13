/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flare.poker;

/**
 *
 * @author Srinivas Akula
 */
public class NotAValidPokerCardException extends RuntimeException {

    public NotAValidPokerCardException(String message) {
        super(message);
    }

    public NotAValidPokerCardException(String message, Throwable cause) {
        super(message, cause);
    }

}
