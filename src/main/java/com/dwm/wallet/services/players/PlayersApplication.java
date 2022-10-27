package com.dwm.wallet.services.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories ("com.dwm.wallet.services.players.repository")
@ComponentScan({"com.dwm.wallet.services.players"})
@EntityScan("com.dwm.wallet.services.players")
public class PlayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayersApplication.class, args);
	}

}
