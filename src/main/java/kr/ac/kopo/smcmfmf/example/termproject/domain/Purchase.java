package kr.ac.kopo.smcmfmf.example.termproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 주문 번호

    private String carModel;   // 차량 모델
    private String carColor;   // 차량 색상
    private String usagePurpose; // 이용 목적
    private String deliveryDate; // 인도 날짜

    private String consumerName; // 고객 이름
    private String consumerPhone; // 전화번호
    private String consumerEmail; // 이메일
}