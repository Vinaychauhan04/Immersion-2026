package binarymanuplation;

class solution {
    public int longestConsecutiveOnes (int n) {
        String binary = Integer.toBinaryString(n);

        int max = 0;
        int count = 0;

        for (char ch : binary.toCharArray()) {
            if (ch == '1') {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args)
{
    solution s = new solution();

System.out.println(s.longestConsecutiveOnes(156));
}}