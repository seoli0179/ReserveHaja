package com.example.reservehaja.data.state;

public enum ServiceState {
    SERVICE_WAIT("서비스대기"),
    RESERVE_START("접수중"),
    RESERVE_END("접수종료"),
    RESERVE_CLOSE("예약마감"),
    SERVICE_END("서비스종료");

    private final String label;

    // enum 생성자
    ServiceState(String label) {
        this.label = label;
    }

    // description 값을 반환하는 getter 메서드
    public String getLabel() {
        return label;
    }

}
