package com.dwm.wallet.services.players.biz.player;

import com.dwm.wallet.services.players.biz.staticValues.MessageBundle;
import com.dwm.wallet.services.players.model.Player;
import com.dwm.wallet.services.players.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/***
 * class for functions which are allowed to select or validate data
 * outer-packages must reach these functions by inheritance classes
 */

abstract class PlayerDataFetch {

    @Autowired
    PlayerRepository playerRepo;

    /**
     * check if specific player is existence
     * @param playerId
     * @return
     */
    protected boolean isPlayerExist(int playerId){
        return playerRepo.existsById(playerId);
    }

    /**
     * return all existence players
     * @return
     */
    protected List<Player> getAllPlayers()
    {
        return playerRepo.findAll();
    }

    /**
     * this function will check validations which need before create any new one
     * @param player
     * @return
     */
    protected MessageBundle validateCreation(Player player)
    {
        /** check input correctness */
        if(player == null) {
            return MessageBundle.validateFail_NoInput;
        }
        if ((player.getPlayerName() == null || player.getPlayerName().equals(null)
                || player.getPlayerName().trim().equals("") || player.getPlayerName().trim() == "")
                || (player.getPlayerFamily() == null || player.getPlayerFamily().equals(null)
                || player.getPlayerFamily().trim().equals("") || player.getPlayerFamily().trim() == "")
                || player.getPlayerTelephone() == 0
        ) {
            return MessageBundle.validateFail_InputValidation;
        }
        /** ****Check telephone constraint****
         * instead of column constraint this validation is checked here to prevent of:
         *         increasing Identity during creation
         *         or
         *         doing other costly functions
         */
        if (playerRepo.existsByPlayerTelephone(player.getPlayerTelephone())) {
            return MessageBundle.validateFail_UserExist;
        }
        return MessageBundle.validateSuccess;
    }

    /**
     * return playerId defined by membershipNo
     * @param membershipNo
     * @return : if player doesn't exist return -1
     */
    protected int getIdByMembershipNo(String membershipNo)
    {
        Player player = playerRepo.findByMembershipNo(membershipNo);
        if(player == null)
        {
            return -1;
        }
        return player.getPlayerId();
    }
}