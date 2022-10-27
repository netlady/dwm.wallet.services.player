package com.dwm.wallet.services.players.controller;

import com.dwm.wallet.services.players.biz.player.PlayerDML;
import com.dwm.wallet.services.players.biz.staticValues.MessageBundle;
import com.dwm.wallet.services.players.model.Player;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller class to access player functions from other apps/services
 */
@RestController
public class PlayerController extends PlayerDML {

    /**
     * get list of players and validate and create profile for each of them
     * @param players
     * @return
     */
    @PostMapping("/players/create")
    public String createMultiPlayerProfile(@RequestBody @Validated List<Player> players)
    {
        return super.createMultiPlayerProfile(players);
    }

    @PostMapping("/player/create")
    public MessageBundle createPlayerProfile(@RequestBody @Validated Player player)
    {
        return super.createPlayerProfile(player);
    }

    /**
     * check if given player has any record
     * @param playerId
     * @return
     */
    @GetMapping("/player/exist/{playerId}")
    public boolean isPlayerExist(@PathVariable int playerId)
    {
        return super.isPlayerExist(playerId);
    }

    /**
     * get id of player which is related to given membershipNo
     * @param membershipNo
     * @return
     */
    @GetMapping("/player/Id/{membershipNo}")
    public int getPlayerIdByMembershipNo(@PathVariable String membershipNo)
    {
        return super.getIdByMembershipNo(membershipNo);
    }

    /**
     * return all players by their raw data
     * @return
     */
    @GetMapping("/players")
    public List<Player> getAllPlayers()
    {
        return super.getAllPlayers();
    }
}