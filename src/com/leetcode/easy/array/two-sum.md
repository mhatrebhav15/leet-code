# Two Sum Solution in Java

### Problem Description

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

### Example
**Input:** nums = [2, 7, 11, 15] target = 9

**Output:** [0, 1]

**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].

### Approach

We will solve the problem using a HashMap. The key idea is to iterate through the array, and for each element, calculate the complement (`target - current element`). We will check if this complement already exists in the HashMap. If it does, we've found our solution.

### Algorithm

1. **Initialize a HashMap** to store the numbers we have seen so far along with their indices.
2. **Iterate through the array**: For each element, calculate the complement (`target - current number`).
3. **Check the HashMap**: If the complement exists, return the indices of the current number and the complement.
4. **If no solution found**, raise an error (though the problem guarantees one solution).
