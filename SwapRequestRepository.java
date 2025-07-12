package main.java.com.swapplatform.repository;

import com.swapplatform.entity.SwapRequest;
import com.swapplatform.entity.SwapStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SwapRequestRepository extends JpaRepository<SwapRequest, Long> {
    List<SwapRequest> findByRequesterIdOrReceiverId(Long requesterId, Long receiverId);
    List<SwapRequest> findByStatus(SwapStatus status);
}