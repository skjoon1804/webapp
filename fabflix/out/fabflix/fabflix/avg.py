import argparse
from itertools import islice
from parse import *
from parse import compile

com = compile("TJ:{TJ} TS:{TS}")
print (com)

counter = 0
tj_sum = 0
ts_sum = 0

with open('test.txt', 'r') as file:
    for line in iter(file):
        counter = counter + 1
        tj_sum = tj_sum + int(com.parse(line)["TJ"])
        ts_sum = ts_sum + int(com.parse(line)["TS"])

print ("total TJ   : " + str(tj_sum))
print ("total TS   : " + str(ts_sum))
print ("total count: " + str(counter))

print ("average TJ : " + str(tj_sum/counter))
print ("average TS : " + str(ts_sum/counter))
