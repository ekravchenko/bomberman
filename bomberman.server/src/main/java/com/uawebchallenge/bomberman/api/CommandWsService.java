package com.uawebchallenge.bomberman.api;

import com.uawebchallenge.bomberman.game.control.GameService;
import com.uawebchallenge.bomberman.game.exception.BombermanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CommandWsService {

    private final GameService gameService;

    private final Logger logger = LoggerFactory.getLogger(CommandWsService.class);

    @Autowired
    public CommandWsService(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/game/{gameId}/player/{playerId}/command")
    public void captureCommand(@DestinationVariable String gameId,
                               @DestinationVariable String playerId,
                               CommandRequest commandRequest) {
        try {
            gameService.addCommand(gameId, playerId, commandRequest.getCommand());
        } catch (BombermanException e) {
            logger.error(e.getMessage());
        }
    }
}
