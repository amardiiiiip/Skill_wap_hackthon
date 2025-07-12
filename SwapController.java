package com.swapplatform.controller;

import com.swapplatform.dto.SwapRequestDTO;
import com.swapplatform.entity.SwapRequest;
import com.swapplatform.service.SwapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/swaps")
public class SwapController {
    @Autowired
    private SwapService swapService;

    @PostMapping
    public ResponseEntity<SwapRequest> createSwap(@Valid @RequestBody SwapRequestDTO dto) {
        return ResponseEntity.ok(swapService.createSwapRequest(dto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<SwapRequest> updateSwapStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(swapService.updateSwapStatus(id, status));
    }
}