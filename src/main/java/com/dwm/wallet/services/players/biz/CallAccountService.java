package com.dwm.wallet.services.players.biz;

import org.springframework.web.client.RestTemplate;

/**
 * class for calling account service functions
 */

public class CallAccountService {

    RestTemplate accountRest = new RestTemplate();
    private final String accountServiceURL = "http://localhost:8080/account";

    /**call creating default account function for new player
     * @param playerId
     * @return : the success of creation will be returned by true/false
     */
    public boolean openPlayerAccount(int playerId)
    {
        String accountURL = String.format("%s/open/def/%d", accountServiceURL, playerId);
        return accountRest.postForObject(accountURL, playerId, boolean.class);
    }
}