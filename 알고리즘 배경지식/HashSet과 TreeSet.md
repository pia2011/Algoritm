## Set

List는 선형 자료구조라면, Set은 비선형 자료구조이다.

Set은 빠른 검색이 필요할 때 사용하며, 중복을 제외한다.

## HashSet vs TreeSet

둘 다 중복을 허용하지 않고 순서가 없는 컬랙션이다.

### 구현방식
* HashSet은 해싱을 이용해서 구현
* TreeSet은 이진탐색트리를 이용해서 구현

### 속도
* HashSet > TreeSet

### 정렬 기능
* HashSet < TreeSet

TreeSet의 경우 데이터의 정렬이 가능하다.(Comparator 이용)



출처 : https://swalloow.tistory.com/36