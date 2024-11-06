import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public String showBoardDetail(@PathVariable Long id, Model model) {
        BoardDTO board = reservationService.getAllBoards().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("board", board);
        return "boardDetail";
    }

    @PostMapping("/{id}/reserve")
    public String reserveBoard(@PathVariable Long id, @RequestParam Long userId) {
        reservationService.reserveBoard(id, userId);
        return "redirect:/board/list";
    }

    @GetMapping("/my-page")
    public String showUserReservations(@RequestParam Long userId, Model model) {
        List<BoardDTO> reservations = reservationService.getUserReservations(userId);
        model.addAttribute("reservations", reservations);
        return "myPage";
    }
}
