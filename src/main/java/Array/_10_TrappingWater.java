package Array;//https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

public class _10_TrappingWater {

    public int trap(int[] height) {

        int[] leftTallest =  new int[height.length];
        int[] rightTallest =  new int[height.length];

        int index = 0;
        int tallestSoFar = 0;

        while(index < height.length){
            leftTallest[index] = tallestSoFar;
            tallestSoFar = Math.max(tallestSoFar, height[index]);
            index++;
        }

        tallestSoFar = 0;
        index = height.length-1;
        while(index >=0 ){
            rightTallest[index] = tallestSoFar;
            tallestSoFar = Math.max(tallestSoFar, height[index]);
            index--;
        }
        int trappedWatter = 0;
        for(int i=0; i<height.length; i++){
            trappedWatter = trappedWatter  + Math.max(0, Math.min(leftTallest[i], rightTallest[i]) - height[i]);
        }

        return trappedWatter;
    }

}

//write approach  + time and space +
