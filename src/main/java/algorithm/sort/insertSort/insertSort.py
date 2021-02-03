def insert_sort(data):
    n = len(data)
    for i in range(n):
        value = data[i]
        change = i
        temp = [0] * 2
        for j in range(i):
            if value >= data[j]: continue
            index = j % 2
            if change == i:
                change = j
                temp[abs(index - 1)] = data[j]
            temp[index] = data[j + 1]
            if index == 0:
                data[j+1] = temp[index+1]
            else:
                data[j+1] = temp[index-1]
        data[change] = value
    return data
