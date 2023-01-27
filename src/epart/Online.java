package epart;


/**
 *온라인 쇼핑몰에서 고객들에게 할인 쿠폰을 지급 예정입니다.
 *기획자는 회원들 나이대별로 다른 쿠폰을 드리고 싶다고 합니다.
 *전체 회원 리스트가 주어질때 회원들을 연령별로 추리하는 코드를 작성해 주세요.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *예시
 {김홍철22세,박종찬9세,김종구31세,문동건27세}
 회원 목록이 위와 같다면
 {박종찬9세}, {김홍철22세,문동건27세}, {김종구31세}의3집합으로 나눠져야합니다.
 */
public class Online {

    public static void main(String[] args) {
    }

    public List<User>[] solution(List<User> inputList) {
        return null;
    }

    static class User {
        int age;
        String name;
    }
}
