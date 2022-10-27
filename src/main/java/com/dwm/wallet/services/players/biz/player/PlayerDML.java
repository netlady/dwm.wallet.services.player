package com.dwm.wallet.services.players.biz.player;

import com.dwm.wallet.services.players.biz.CallAccountService;
import com.dwm.wallet.services.players.biz.staticValues.MessageBundle;
import com.dwm.wallet.services.players.model.Player;

import java.util.List;

/**
 * All main logic functions for player which may other classes need
 */
public class PlayerDML extends PlayerDataManipulate {

    /**
     * insert new player besides checking its validation
     *
     * @param player
     * @return
     */
    public MessageBundle createPlayerProfile(Player player) {
        /** ****Check creation validation**** */
        MessageBundle resultStatus = validateCreation(player);
        if (resultStatus != MessageBundle.validateSuccess) {
            return resultStatus;
        }

        /** insert player */
        resultStatus = insertPlayer(player);
        if (resultStatus != MessageBundle.saveSuccess) {
            return resultStatus;
        }

        /** create default account for player */
        boolean playerAccountOpenedResult = new CallAccountService().openPlayerAccount(player.getPlayerId());
        if (!playerAccountOpenedResult) {
            return MessageBundle.saveSuccess_withoutAccount;
        }
        return MessageBundle.saveSuccess;
    }

    /**
     * insert list of player and return a summary of result in terms of items which are success or faild
     *
     * @param players
     * @return
     */
    public String createMultiPlayerProfile(List<Player> players) {
        if (players == null) {
            return MessageBundle.validateFail_NoInput.toString();
        }
        /** ****variables to save each player's insertion status**** */
        String strFailResult = "", strIdsSuccessWithoutAccount = "";
        int cntFail = 0, cntPlayers = 0;
        for (Player player : players) {
            cntPlayers++;
            /** create profile for each given player*/
            MessageBundle strSaveResult = createPlayerProfile(player);
            if (strSaveResult != MessageBundle.saveSuccess && strSaveResult != MessageBundle.saveSuccess_withoutAccount) {
                cntFail++;
                strFailResult += String.format("\nPlayer %d due to %s", cntPlayers, strSaveResult.toString());
            } else {
                if (strSaveResult == MessageBundle.saveSuccess_withoutAccount) {
                    strIdsSuccessWithoutAccount += String.format(" %d ", cntPlayers);
                }
            }
        }
        /** ****print the result**** */
        return String.format("Saved Players: %d number \n" +
                        "Saved Players with out creating account: %s \n" +
                        "Failed Players: %d number \n\n %s",
                cntPlayers - cntFail, strIdsSuccessWithoutAccount, cntFail, strFailResult);
    }

    public int getIdByMembershipNo(String membershipNo)
    {
        return super.getIdByMembershipNo(membershipNo);
    }
}