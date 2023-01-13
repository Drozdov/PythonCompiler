#Calculates approximate value of PI using Monte Carlo method

iterations = 100000
success = 0

for i in range(0, iterations):
    x = random()
    y = random()

    if x * x + y * y < 1:
        success = success + 1

print("PI = " + str(4.0 * success / iterations))


