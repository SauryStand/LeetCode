import sys
if __name__ == "__main__":
    s = sys.stdin.readline()
    n = len(s)
    length = -1

    stack = []
    for c in s:
        if not stack or stack[-1][0] != c:
            stack.append([c,1])
        elif stack[-1][1] + 1 < 3:
            stack[-1][1] += 1
        else:
            stack.pop()
    res = ''
    for c, l in stack:
        res += c*l
    print(res)

    # while length != n:
    #     length = n
    #     count = 1
    #     for i in range(n):
    #         if i == 0 or s[i] != s[i-1]:
    #             count = 1
    #         count += 1
    #         if count > 2:
    #             s.replace(s[i - count + 1:i + 1], '')
    #             break
    # print(s)

    # s2 = s1[::-1]
    # start = 0
    # end = 0
    # temp = ''
    # for i in range(n):
    #     for j in range(i):
    #         if s1[i] == s1[j]:
    #             temp += s1[i]
    # common = temp[::-1] + temp
    # #s = s.replace()
    # print(common)


