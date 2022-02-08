package B208.mag_jang.controller;

import B208.mag_jang.domain.ChatRoomDTO;
import B208.mag_jang.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class RoomController {

    private final ChatRoomRepository repository;

    public RoomController(ChatRoomRepository repository) {
        this.repository = repository;
    }

    //채팅방 목록 조회
//    @GetMapping(value = "/rooms")
//    public ModelAndView rooms(){
//        ModelAndView mv = new ModelAndView("chat/rooms");
//        mv.addObject("list", repository.findAllRooms());
//
//        return mv;
//    }

    //채팅방 목록 조회 - rest
    @GetMapping(value = "/rooms")
    public ResponseEntity<List<ChatRoomDTO>> rooms(){
        List<ChatRoomDTO> list = repository.findAllRooms();
        if(list.size()==0){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(list);
        }
    }

    //채팅방 개설
//    @PostMapping(value = "/room")
//    public String create(@RequestParam String name, RedirectAttributes rttr){
//        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
//        return "redirect:/chat/rooms";
//    }

    //채팅방 개설 - rest
    @PostMapping(value = "/room")
    public ResponseEntity<ChatRoomDTO> create(@RequestParam String name){
        ChatRoomDTO room = repository.createChatRoomDTO(name);
        if(room == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(room);
        }
    }

    //채팅방 조회
//    @GetMapping("/room")
//    public void getRoom(String roomId, Model model){
//        model.addAttribute("room", repository.findRoomById(roomId));
//    }

    //채팅방 조회 - rest
    @GetMapping("/room")
    public ResponseEntity<ChatRoomDTO> getRoom(String roomId){
        ChatRoomDTO room = repository.findRoomById(roomId);
        if(room == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(room);
        }
    }
}
