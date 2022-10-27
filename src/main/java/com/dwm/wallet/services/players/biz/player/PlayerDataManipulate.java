package com.dwm.wallet.services.players.biz.player;

import com.dwm.wallet.services.players.biz.staticValues.MessageBundle;
import com.dwm.wallet.services.players.model.Player;

/**
 * abstract class for functions which are allowed to manipulate player's data
 * outer-packages must reach these functions by inheritance classes
 * note: all validations of each function must be called before these functions on logical part
 */

abstract class PlayerDataManipulate extends PlayerDataFetch {

    /**
     * create new record for given player
     * @param player
     * @return
     */
    protected MessageBundle insertPlayer(Player player)
    {
        player.setRegisterDate();
        player.setMembershipNo();
        playerRepo.save(player);
        return MessageBundle.saveSuccess;
    }
}