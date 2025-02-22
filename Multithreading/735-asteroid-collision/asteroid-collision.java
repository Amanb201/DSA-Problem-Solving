class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<asteroids.length; i++){
            if(asteroids[i]>0){
                //If curr Asteroid moving in Right direction (i.e. element is +ve) then we can add as,doesn't matter previously stk 
                //is Empty or top has +ve element or -ve element, it wouldn't COLLIDE
                stk.push(asteroids[i]);
            }
            else{
                //Curr Asteroid is moving in Left Direction then there are chances it can collide with right moving Asteroid if any
                while(!stk.isEmpty() && stk.peek()>0 && Math.abs(stk.peek())<Math.abs(asteroids[i])){
                    //Curr Asteroids keep colliding and destroying right moving asteroid which are smaller than curr Asteroid
                    stk.pop();
                }

                if(stk.isEmpty() || stk.peek()<0){
                    //There is no collision if top of stack contains Asteroid moving in left direction or there is no Asteroid at all
                    stk.push(asteroids[i]);
                }
                else if(!stk.isEmpty() && stk.peek() == Math.abs(asteroids[i])){
                    //Stack is not empty and contains the Right moving Asteroid, which is of equal size, so both needs to be destroyed
                    stk.pop();
                }
                //Last case would be top of Stack has the Right moving Asteroid which is larger in size than curr Asteroid,
                // so curr Asteroid would get deleted
            }
        }

        int[] finalAsteroids = new int[stk.size()];
        for(int i=stk.size()-1; i>=0; i--){
            finalAsteroids[i] = stk.pop();
        }
        return finalAsteroids;
    }
}