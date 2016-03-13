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
public class NotAValidPokerHandException extends RuntimeException {

    public NotAValidPokerHandException(String message) {
        super(message);
    }

    public NotAValidPokerHandException(String message, Throwable cause) {
        super(message, cause);
    }

}
