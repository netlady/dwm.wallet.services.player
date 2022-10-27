package com.dwm.wallet.services.players.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

/**
 * Player entity structure
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue
    private int playerId;
    private String playerName;
    private String playerFamily;
    @Column(unique = true)
    private int playerTelephone;
    @Column(unique = true)
    private String membershipNo;
    private Date registerDate;

    public void setMembershipNo() {
        membershipNo = String.format("ply%03dn%03d", new Date().getYear() + 1900, new Random().nextInt(999));
    }

    public void setRegisterDate() {
        registerDate = new Date();
    }
}