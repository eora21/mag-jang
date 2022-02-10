package B208.mag_jang.controller;

import B208.mag_jang.domain.ChatMessageDTO;
import B208.mag_jang.domain.GameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value="/game")
public class GameController {
    private final SimpMessagingTemplate template;


    @MessageMapping(value = "/start")
    public void enter(ChatMessageDTO message){

        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
        System.out.println(message.getWriter()+ "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        System.out.println(template.getMessageChannel());

        String roomId = "";
        GameDTO game = new GameDTO(roomId);
    }

}
