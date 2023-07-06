package io.musinsa.searchplatformkafkaproducer.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsVO {
    @JsonPropertyDescription("상품 ID: 상품 번호와 동일, 색인, 검색시 사용")
    private String id;

    @JsonPropertyDescription("상품 번호")
    private Long no;

    @JsonPropertyDescription("품번")
    private String styleNo;

    @JsonPropertyDescription("이미지 정보")
    private Image image;

    @JsonPropertyDescription("상품 생성 일자")
    private String createDate;

    @JsonPropertyDescription("상품 업데이트 일자")
    private String updateDate;

    @JsonPropertyDescription("색인 일자")
    private String lastUpdateDate;

    @JsonPropertyDescription("쿠폰 정보")
    private List<Coupon> coupon;

    @JsonPropertyDescription("상품명 정보")
    private Name name;

    @JsonPropertyDescription("상품 가격 정보")
    private Price price;

    @JsonPropertyDescription("색상 정보")
    private List<Color> color;

    @JsonPropertyDescription("카테고리 정보")
    private List<Category> category;

    @JsonPropertyDescription("브랜드 정보")
    private Brand brand;

    @JsonPropertyDescription("후기 정보")
    private Review review;

    @JsonPropertyDescription("조건 정보")
    private Condition condition;

    @JsonPropertyDescription("랭킹 - 가중치")
    private Rank rank;

    @JsonPropertyDescription("성별 정보")
    private Gender gender;

    @JsonPropertyDescription("태그 정보")
    private Tag tag;

    @JsonPropertyDescription("세일 정보")
    private Sale sale;

    @JsonPropertyDescription("출시일 정보")
    private Release release;


    @JsonPropertyDescription("클리어런스 정보")
    private Clearance clearance;

    @JsonPropertyDescription("옵션 정보")
    private Option option;

    @JsonPropertyDescription("뱃지 정보")
    private Badge badge;

    @JsonPropertyDescription("신상품 정보")
    private NewProduct newProduct;


    private Map<String, Object> custom = new HashMap<>();

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    public static class Image {

        @JsonPropertyDescription("pc 이미지")
        private String pc;
        @JsonPropertyDescription("모바일 이미지")
        private String mobile;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    public static class Coupon {

        @JsonPropertyDescription("쿠폰 번호")
        private String no;
        @JsonPropertyDescription("쿠폰 이름")
        private String name;

        @JsonPropertyDescription("쿠폰 - 할인율")
        private Float discountRate;
        @JsonPropertyDescription("쿠폰 - 적용가")
        private Long discount;
        @JsonPropertyDescription("쿠폰 시작일")
        private String startDate;

        @JsonPropertyDescription("쿠폰 종료일")
        private String endDate;

        @JsonPropertyDescription("쿠폰 적용 시작일")
        private String applicationStartDate;

        @JsonPropertyDescription("쿠폰 적용 종요일")
        private String applicationEndDate;

        @JsonPropertyDescription("쿠폰 제한 Yn")
        private String limitedCouponYn;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Name {

        @JsonPropertyDescription("상품명 현지 언어")
        private String local;
        @JsonPropertyDescription("상품 영문명")
        private String english;

        @JsonPropertyDescription("상품 홍보글 예:[박서준 착용]")
        private String headDesc; //신규 생성

        private Map<String, Object> custom = new HashMap<>();
    }


    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    public static class Price {

        @JsonPropertyDescription("상품가격 - 정상가")
        private Long normal;
        @JsonPropertyDescription("상품가격 - 할인 상품가격")
        private Long sale;
        @JsonPropertyDescription("상품가격 - 쿠폰가")
        private Long coupon;
        @JsonPropertyDescription("상품가격 - 정가")
        private Long list;

        @JsonPropertyDescription("상품가격 - 할인가")
        private Long discount;
        @JsonPropertyDescription("상품가격 - 할인율")
        private Float discountRate;

        private Map<String, Object> custom  = new HashMap<>();
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    public static class Color {
        @JsonPropertyDescription("색상-코드")
        private String code;
        @JsonPropertyDescription("색상명")
        private String name;
        @JsonPropertyDescription("코드명@#색상명")
        private String concatenationName;
        @JsonPropertyDescription("코드명@#색상명")
        private Map<String, Object> custom = new HashMap<>();

    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    public static class Category {
        private String code;
        private Name name;
        private String entireName;
        private String type;

        @JsonPropertyDescription("카테고리 뎁스")
        private Integer layer;
        @JsonPropertyDescription("카테고리 랭킹 정보")
        private Rank rank;

        @JsonPropertyDescription("카테고리 enrich 정보")
        private List<Depth> depth;

        @JsonPropertyDescription("카테고리 태그 정보")
        private List<String> systemTag;
        @JsonPropertyDescription("카테고리 사용 여부")
        private String useYn;

        @JsonPropertyDescription("성별")
        private Gender gender;

        @JsonPropertyDescription("커스텀")
        private Map<String, Object> custom = new HashMap<>();

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        public static class Name {

            @JsonPropertyDescription("카테고리 현지 언어")
            private String local;
            @JsonPropertyDescription("카테고리 영문명")
            private String english;

            private Map<String, Object> custom = new HashMap<>();

        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Rank {

            @JsonPropertyDescription("카테고리 시퀀스")
            private Float sequence;

            @JsonPropertyDescription("카테고리 태그- [\"셔츠\", \"남방\"]")
            private List<String> tag;
        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @NoArgsConstructor
        public static class Gender {

            @JsonPropertyDescription("성별 코드 - male, female, unisex")
            private List<String> code;
            @JsonPropertyDescription("성별 필터 - A M F")
            private List<String> filter;
        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @NoArgsConstructor
        public static class Depth {

            @JsonPropertyDescription("카테고리 id")
            private String id;
            @JsonPropertyDescription("카테고리 코드 1")
            private String code1;

            @JsonPropertyDescription("카테고리 코드 2")
            private String code2;

            @JsonPropertyDescription("카테고리 코드 3")
            private String code3;

            @JsonPropertyDescription("대카테고리")
            private String name1;

            @JsonPropertyDescription("중카테고리")
            private String name2;

            @JsonPropertyDescription("소카테고리")
            private String name3;

            @JsonPropertyDescription("타입")
            private String type;

            @JsonPropertyDescription("대카테고리명 - 001@반팔")
            private String concatenation1;

            @JsonPropertyDescription("중카테고리명 - 001001@반팔")
            private String concatenation2;

            @JsonPropertyDescription("소카테고리명 - 001001001@반팔")
            private String concatenation3;

            @JsonPropertyDescription("카테고리 풀네임: 대카테고리 > 중카테고리 > 소카테고리명")
            private String entireName;

            @JsonPropertyDescription("카테고리 시퀀스")
            private Float sequence;

            private Map<String, Object> custom = new HashMap<>();

        }
    }


    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    public static class Brand {

        private String id;
        private Name name;
        private Tag tag;
        private Rank rank;
        private Condition condition;
        private Map<String, Object> custom = new HashMap<>();


        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @NoArgsConstructor
        public static class Name {

            @JsonPropertyDescription("브랜드명 현지 언어")
            private String local;
            @JsonPropertyDescription("브랜드 영문명")
            private String english;

            @JsonPropertyDescription("ID + 브랜드명 현지 언어")
            private String entireLocal; //생성

            @JsonPropertyDescription("ID + 영문명")
            private String entireEnglish; //생성
        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @NoArgsConstructor
        public static class Tag {

            @JsonPropertyDescription("동의어")
            private List<String> synonyms;
            @JsonPropertyDescription("시스템 태그")
            private List<String> system;
            @JsonPropertyDescription("레이블: 브랜드의 대표 상품 태그 등을 추가 (애플 -> 아이폰, 아이패드)")
            private List<String> label;
        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @NoArgsConstructor
        public static class Condition {

            @JsonPropertyDescription("베스트 Yn")
            private String bestYn;

            @JsonPropertyDescription("제외 브랜드 Yn")
            private String exclusiveYn;

            @JsonPropertyDescription("사용 여부 Yn")
            private String useYn;

            @JsonPropertyDescription("멀티 성별 여부 Yn - 2개 이상의 성별을 가지고 있는지 확인")
            private String multiGenderYn;

            private Map<String, Object> custom = new HashMap<>();

        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        public static class Rank {

            @JsonPropertyDescription("브랜드 시퀀스 번호")
            private Integer sequence;

            @JsonPropertyDescription("브랜드 랭킹 점수")
            private Points points;


            @JsonPropertyDescription("브랜드 커스텀 랭킹 점수")
            public Map<String, Object> custom = new HashMap<>();

            @Getter
            @Setter
            @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
            @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Points {

                @JsonPropertyDescription("브랜드 랭킹 점수")
                private Float all;

                @JsonPropertyDescription("랭킹포인트 - 연령1 점수")
                private Float seg1;

                @JsonPropertyDescription("랭킹포인트 - 연령2 점수")
                private Float seg2;

                @JsonPropertyDescription("랭킹포인트 - 연령3 점수")
                private Float seg3;

                @JsonPropertyDescription("랭킹포인트 - 연령4 점수")
                private Float seg4;

                @JsonPropertyDescription("랭킹포인트 - 연령5 점수")
                private Float seg5;

                @JsonPropertyDescription("랭킹포인트 - 연령6 점수")
                private Float seg6;
            }
        }

    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Review {

        @JsonPropertyDescription("리뷰 - 갯수")
        private Integer count;
        @JsonPropertyDescription("리뷰 - 별점")
        private Float grade;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {

        private String saleStatus;
        private String usedYn;
        private String searchYn;
        private String displayYn;
        private String raffleYn;
        private String multiGenderYn;
        private String setupYn;
        private Map<String, Object> custom = new HashMap<>();
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rank {

        @JsonPropertyDescription("상품 시퀀스 번호")
        private Integer sequence;

        @JsonPropertyDescription("랭킹 포인트 - 전체 점수")
        private Points points;

        private Weight weight;

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Points {

            @JsonPropertyDescription("랭킹포인트 - 전체 점수")
            private Float all;

            @JsonPropertyDescription("랭킹포인트 - 연령0 점수")
            private Float seg0;

            @JsonPropertyDescription("랭킹포인트 - 연령1 점수")
            private Float seg1;

            @JsonPropertyDescription("랭킹포인트 - 연령2 점수")
            private Float seg2;

            @JsonPropertyDescription("랭킹포인트 - 연령3 점수")
            private Float seg3;

            @JsonPropertyDescription("랭킹포인트 - 연령4 점수")
            private Float seg4;

            @JsonPropertyDescription("랭킹포인트 - 연령5 점수")
            private Float seg5;

            @JsonPropertyDescription("랭킹포인트 - 연령6 점수")
            private Float seg6;
        }
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weight {

        @JsonPropertyDescription("랭킹 - 가중치 - 사용자 클릭 - 키워드(매핑)")
        private List<CustomerClick> customerClick;

        private Name name;

        private Map<String, Object> custom = new HashMap<>();

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CustomerClick {
            @JsonPropertyDescription("랭킹 - 가중치 - 사용자 클릭 - 키워드(매핑)")
            private String keyword;
            @JsonPropertyDescription("랭킹 - 가중치 - 사용자 클릭 - 카테고리 스코어")
            private Double categoryScore;
            @JsonPropertyDescription("랭킹 - 가중치 - 사용자 클릭 - 상품 스코어")
            private Double goodsScore;
        }

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Name {

            @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            private List<String> gender;

            @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            private List<String> categoryEntire;

            @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            private List<String> category1;

            @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            private List<String> category2;

            @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            private List<String> category3;
            private String brand;

            @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            private List<String> color;
        }
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Gender {

        @JsonPropertyDescription("성별 코드 - male, female, unisex")
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        private List<String> code;

        @JsonPropertyDescription("성별 필터 - A M F")
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        private List<String> filter;

        @JsonPropertyDescription("성별 태그 - 남성, 여성, 키즈, 라이프 등")
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        private List<String> tag;



    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tag {

        @JsonPropertyDescription("동의어")
        private List<String> synonyms;
        @JsonPropertyDescription("시스템 태그")
        private List<String> system;

        @JsonPropertyDescription("커스텀 태그")
        private Map<String, Object> custom = new HashMap<>();
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sale {

        private String saleYn;
        private String code;
        private String periodType;
        private String saleDateYn;
        @JsonPropertyDescription("세일 - 타임 세일 여부")
        private String timeSaleYn;
        @JsonPropertyDescription("세일 - 기간 사용 여부")
        private String sellDateUseYn;
        @JsonPropertyDescription("세일 - 판매 시작 기간")
        private String sellStartDate;
        @JsonPropertyDescription("세일 - 판매 종료 기간")
        private String sellEndDate;

        @JsonPropertyDescription("세일 - 할인 시작일")
        private String saleStartDate;

        @JsonPropertyDescription("세일 - 할인 종료일")
        private String saleEndDate;


        private String familySaleYn;
        private String familySaleStartDate;
        private String familySaleEndDate;

        private Count count;

        private Map<String, Object> custom = new HashMap<>();

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Count {
            @JsonPropertyDescription("세일 - 일자별 판매수")
            private Integer oneDay;

            @JsonPropertyDescription("세일- 주간 판매수")
            private Integer oneWeek;

            @JsonPropertyDescription("세일 - 월간 판매수")
            private Integer oneMonth;

            @JsonPropertyDescription("세일 - 3개월간 판매수")
            private Integer threeMonth;

            @JsonPropertyDescription("세일 - 1년간 판매수")
            private Integer oneYear;

        }

    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Release {
        @JsonPropertyDescription("상품 출시일")
        private String date;

        @JsonPropertyDescription("상품 출시 여부")
        private String releaseYn;

        @JsonPropertyDescription("상품 출시 년도 정보")
        private String year;

        @JsonPropertyDescription("상품 출시 시즌 정보")
        private String season;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Clearance {

        @JsonPropertyDescription("클리어런스 상품 여부")
        private String clearanceYn;

        @JsonPropertyDescription("클리어런스 년도 정보")
        private String year;

        @JsonPropertyDescription("클리어런스 월간 정보")
        private String month;

        @JsonPropertyDescription("클리어런스 주간 정보")
        private String week;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Option {

        @JsonPropertyDescription("신발 옵션 정보")
        private String shoeSize;

        @JsonPropertyDescription("상의 옵션 정보")
        private String topSize;


        @JsonPropertyDescription("상품 옵션 정보 - 주요소재, 소매기장, 핏, 상의기장")
        private GoodsSize goodsSize;

        @Getter
        @Setter
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class GoodsSize {

            private String item;
            private String size;
            private String option;
            private String quantity;
        }
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Badge {

        @JsonPropertyDescription("뱃지 명")
        private String title;

        @JsonPropertyDescription("뱃지 색상")
        private String color;

    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NewProduct {

        @JsonPropertyDescription("신상품 적용 일자")
        private String day;

        @JsonPropertyDescription("신상품 적용유형(R:등록일_M:집적입력)")
        private String type;

    }



}