# 매일의 온도를 나타내는 int형 배열 temperatures 가 주어지면 
# answer배열의 원소 answer[i]는 i번째 날의 온도 보다 더 따뜻해지기까지 며칠을 기다려야하는지 나타낸다.
# 띠뜻해지는 날이 없다면 answer[i] == 0 이다.
#
# 제약조건: 1 <= temperatures.length <= 10**5 
# -> 시간복잡도 10**8 을 넘으면 안되기 때문에 O(n**2) 으로 풀면 안된다
# -> 시간 복잡도를 줄이기위해 sort 를 사용하면 날자계산을 위한순서가 흐트러지기 때문에 stack 구조를 사용한다(시간복잡도: O(n))
#
# 예제1
# input: temperatures = [73,74,75,71,69,72,76,73]
# output: [1,1,4,2,1,1,0,0]
#
# 예제2
# input: temperatures = [30,60,90]
# output: [1,1,0]

def dailyTemperatures(temperatures):
    ans = [0] * len(temperatures) # 초기화
    stack = []

    for cur_day, cur_temp in enumerate(temperatures):
        while stack and stack[-1][1] < cur_temp: # 새로운 온도가 현재 온도 보다 높을 때만 계산
            prev_day, _ = stack.pop()
            ans[prev_day] = cur_day - prev_day
        stack.append((cur_day, cur_temp))
    return ans