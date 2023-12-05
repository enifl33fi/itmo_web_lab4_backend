package com.enifl33fi.lab4_backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckService {

    public boolean isInArea(double x, double y, double r) {
        return isInTriangle(x, y, r)
                || isInCircle(x, y, r)
                || isInRectangle(x, y, r);
    }

    private boolean isInTriangle(double x, double y, double r) {
        return x >= 0 && y >= 0 && y + x - r <= 0;
    }

    private boolean isInCircle(double x, double y, double r) {
        return x <= 0 && y >= 0 && (x * x + y * y) <= r * r;
    }

    private boolean isInRectangle(double x, double y, double r) {
        return x <= 0 && y <= 0 && x >= -r && y >= -r/2;
    }
}
