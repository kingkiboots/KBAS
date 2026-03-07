"""
Q. 멜론에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 한다.

노래는 인덱스로 구분하며, 노래를 수록하는 기준은 다음과 같다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록한다. (단, 각 장르에 속한 노래의재생 수 총합은 모두 다르다.)

2. 장르 내에서 많이 재생된 노래를 먼저 수록한다.

3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록한다.


노래의 장르를 나타내는 문자열 배열 genres와
노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,

베스트 앨범에 들어갈 노래의 인덱스를 순서대로 반환하시오.
"""

"""
많이 라는 말이 나오면 무조건 정렬을 사용한다.
"""

def get_melon_best_album(genre_array, play_array):
    N = len(genre_array)
    genre_total_play_dict = {} # dict에 장르별로 얼마나 재생횟수를 가지고 있는가
    genre_index_play_array_dict = {}
    
    for i in range(N):
        genre = genre_array[i]
        play = play_array[i]

        if genre in genre_total_play_dict: # genre 라는 키 값이 있으면
            genre_total_play_dict[genre] += play # 재생 횟수 더하기
            genre_index_play_array_dict[genre].append([i, play])
        else: # 키 값이 없는 상황이라면
            genre_total_play_dict[genre] = play # 재생횟수 지정
            genre_index_play_array_dict[genre] = [[i, play]]

    # 장르별로 가장 재생 횟수가 많은 장르들 중, 곡수가 많은 순서대로 2개씩 출력하기
    sorted_genre_play_array = sorted(genre_total_play_dict.items(), key=lambda x: x[1], reverse=True)
    
    result = []
    for genre, _total_play in sorted_genre_play_array:
        sorted_genre_index_play_array = sorted(genre_index_play_array_dict[genre], key=lambda x: (-x[1], x[0]))
        
        for index, _play in sorted_genre_index_play_array[:2]:
            result.append(index)
    
    return result



print("정답 = [4, 1, 3, 0] / 현재 풀이 값 = ", get_melon_best_album(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
print("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = ", get_melon_best_album(["hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"], [2000, 500, 600, 150, 800, 2500, 2000]))