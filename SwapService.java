package main.java.com.swapplatform.service;

import com.swapplatform.dto.SwapRequestDTO;
import com.swapplatform.entity.SwapRequest;
import com.swapplatform.entity.SwapStatus;
import com.swapplatform.repository.SwapRequestRepository;
import com.swapplatform.repository.UserRepository;
import com.swapplatform.repository.SkillOfferedRepository;
import com.swapplatform.repository.SkillWantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwapService {
    @Autowired
    private SwapRequestRepository swapRequestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillOfferedRepository skillOfferedRepository;
    @Autowired
    private SkillWantedRepository skillWantedRepository;

    public SwapRequest createSwapRequest(SwapRequestDTO dto) {
        SwapRequest swap = new SwapRequest();
        swap.setRequester(userRepository.findById(dto.getRequesterId())
                .orElseThrow(() -> new RuntimeException("Requester not found")));
        swap.setReceiver(userRepository.findById(dto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found")));
        swap.setSkillOffered(skillOfferedRepository.findById(dto.getSkillOfferedId())
                .orElseThrow(() -> new RuntimeException("Skill offered not found")));
        swap.setSkillWanted(skillWantedRepository.findById(dto.getSkillWantedId())
                .orElseThrow(() -> new RuntimeException("Skill wanted not found")));
        swap.setStatus(SwapStatus.PENDING);
        return swapRequestRepository.save(swap);
    }

    public SwapRequest updateSwapStatus(Long id, String status) {
        SwapRequest swap = swapRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Swap request not found"));
        swap.setStatus(SwapStatus.valueOf(status.toUpperCase()));
        return swapRequestRepository.save(swap);
    }
}