package com.dwm.wallet.services.players.repository;

import com.dwm.wallet.services.players.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for player entity
 */

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    //note: telephone number is a unique field
    boolean existsByPlayerTelephone(int playerTelephone);

    Player findByMembershipNo(String membershipNo);
}