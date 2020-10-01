/**
*@author : Marwa Bouabid
*@version : 09/15/2020
*/

package plane;

public class Plane {
	
	//Variables we will need for out program
	
	private boolean wheelsUp = false; 
	
	private boolean doorsOpen = true; 
	
	private int speed = 0;  
	
	private boolean isOnGround = true; 
	
	private boolean doorsOpenWhileMoving = false;
	
	private boolean stoppingInTheAir = false;
	
	private boolean stoppingWhileTooFast = false;
	
	private boolean taxiInTheAir = false;
	
	private boolean doorsOpenInTheAir = false;
	
	private boolean wheelsUpOnTheGround = false;
	
	private boolean doorsOpenWhileTaxi = false;
	
	private boolean takingOffFromAir = false;
	
	private boolean takingOffWrongSpeed = false;
	
	private boolean landingFromGround = false; 
	
	private boolean landingWrongSpeed = false;
	
	private boolean throttleUpWhileTooSlow = false;
	
	private boolean speedWrongValue = false;
	
	private boolean decreaseWrongValue = false; 
	
	private boolean increaseWrongValue = false;
		
	/*This method makes the plane take off
     * It takes no parameters and doesn't return anything
     */
    public void takeOff() {
    	int takeOffSpeed = 160; //Necessary speed to take off
    	printStatus(); //Printing status of the plane
    	System.out.println ("\nTaking off"); 
    	//The safe action to take if the preconditions are not respected
    	//is to stay on the ground. If the conditions aren't respected, the if statements
    	//Will be executes and no action will be taken
    	
    	//Precondition : the plane should only take off if it's on the ground
    	if(!isOnGround) 
    	{
    		System.out.println("No ! Not gonna work..."
    				+ "plane is already in the air!");
    		takingOffFromAir = true;
    	}
    	//Precondition : the plane should only take off if the speed is 160mph
    	else if(speed != takeOffSpeed) 
    	{
    		System.out.println("No ! Check your speed, pilot ! "
    				+ "(should be 160mph)");
    		takingOffWrongSpeed = true;
    	}
    	//Postcondition : The plane takes off 
    	else 
    	{
    	isOnGround = false;
        }
    	assert wellFormed();
    }
    
    /*This method makes the plane land
     * It takes no parameters and doesn't return anything
     */
    public void land() {
    	int landingSpeed = 140;
    	printStatus();
    	System.out.println ("\nLanding");
    	//The safe action to take if the preconditions are not respected
    	//is to stay in the air. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken
    	
    	//Precondition : The plane should only land if it's in the air
    	if(isOnGround)
    	{
    		System.out.println("No ! Not sure you'll be "
    				+ "able to land if you're already on the ground !");
    		landingFromGround = true;
    	}
    	//Precondition : The speed during landing should always be 140mph
    	else if(speed != landingSpeed)
    	{
    		System.out.println("No ! Check your speed, "
    				+ "pilot... (should be 140mph)");
    		landingWrongSpeed = true;
    	}
    	//Postcondition : the plane lands
    	else
    	{
    	isOnGround = true;
    	}
        assert wellFormed();
    }

    /*This method makes the plane taxi
     * It takes no parameters and doesn't return anything
     */
    public void taxi() {
    	printStatus();
    	System.out.println ("\nTaxiing");
    	//The safe action to take if the preconditions are not respected
    	//is to not change the speed. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken.
    	
    	//Precondition : The plane should only land if it's in the air
    	if(!isOnGround)
    	{
    		System.out.println("No ! Pretty sure the plane will "
    				+ "fall if you taxi in the air");
    		taxiInTheAir = true;
    	}
    	//Precondition : The doors should never be open if the plane is moving
    	else if (doorsOpen)
    	{
    		System.out.println("No ! If you open doors "
    				+ "while taxiing, people will fall");
    		doorsOpenWhileTaxi = true;
    	}
    	//Postcondition : The speed becomes 20mph
    	else
    	{
        speed = 20;
        }
        assert wellFormed();
    }
    
    /*This method stops the plane
     * It takes no parameters and doesn't return anything
     */
    public void stop() {
    	printStatus();
    	System.out.println ("\nStopping");
    	//The safe action to take if the preconditions are not respected
    	//is to not change the speed. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken.
    	
    	//Precondition : The plane should never stop mid-air
    	if (!isOnGround)
    	{
    		System.out.println("No ! Pretty sure the plane "
    				+ "will fall if you stop mid-air...");
    		stoppingInTheAir = true;
    	}
    	//Precondition : The plane should never stop if its speed is greater than 20mph
    	else if (speed != 20)
    	{
    		System.out.println("No ! Chech your speed pilot..."
    				+ "(should be 20mph)");
    		stoppingWhileTooFast = true;
    	}
    	//Postcondition : The plane stops
    	else
    	{
        speed = 0;
    	}
        assert wellFormed();
    }

    /*This method opens the doors of the plane
     * It takes no parameters and doesn't return anything
     */
    public void openDoors()  {
    	printStatus();
    	System.out.println ("\nOpening doors");
    	//The safe action to take if the preconditions are not respected
    	//is to keep the doors closed. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken.
    	
    	//Precondition : doors should never open while the plane is moving
    	if(speed != 0)
    	{
    		System.out.println("No ! If the doors are open while "
    				+ "the plane is moving, people will fall...");
    		doorsOpenWhileMoving = true;
    	}
    	//Precondition : doors should never be open when the plane is in the air
    	else if(!isOnGround)
    	{
    		System.out.println("No ! Close your doors, are you "
    				+ "sure you want to depressurize your plane ?");
    		doorsOpenInTheAir = true;
    	}
    	//Postcondition : The doors open
    	else
    	{
    	doorsOpen = true;
    	}
        assert wellFormed();

    }
    
    /*This method closes the doors of the plane
     * It takes no parameters and doesn't return anything
     */
    public void closeDoors() {
    	printStatus();
    	System.out.println ("\nClosing doors");
    	//It's always safe to close the doors. 
    	
    	//Preconditions : None
    	//Postcondition : The doors close
    	doorsOpen = false;
        assert wellFormed();
    }

    /*This method puts the wheels up
     * It takes no parameters and doesn't have any return value
     */
    public void putWheelsUp() {
    	printStatus();
    	System.out.println ("\nPutting wheels up");
    	//The safe action to take if the preconditions are not respected
    	//is to keep the wheels down. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken.
    	
    	//Precondition : the plane should never be on the ground
    	if (isOnGround)
    	{
    		System.out.println("No ! Wheels cannot "
    				+ "be up if the plane is on the ground");
    		wheelsUpOnTheGround = true;
    	}
    	//Postcondition : the wheels are put up 
    	else 
    	{
    	wheelsUp = true;
    	}
        assert wellFormed(); 
    }
    
    /*This method puts the wheels down. 
     * It takes no parameter and doesn't have any return value
     */
    public void putWheelsDown() {
    	printStatus();
    	System.out.println ("\nPutting wheels down");
    	//It is always safe to put the wheels down
    	//Preconditions : none
    	//Postconditions : the wheels are put down
    	wheelsUp = false;
    	
        assert wellFormed();  
    }

    /*This method increases the speed of the plane.
     * It takes no parameters and doesn't have any return value
     */
    public void throttleUp(int increase) { 
    	int minSpeed = 160;
    	printStatus();
    	System.out.println("\nThrottling up");
    	//The safe action to take if the preconditions are not respected
    	//is to keep the same speed. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken.
    	
    	//Precondition : the speed should at least be 20mph
    	if (speed < 20)
    	{
    		System.out.println("No ! Speed should "
    				+ "be at least 20mph to trottle up");
    		throttleUpWhileTooSlow = true; 
    	}
    	//Precondition : Increase should be a positive integer
    	else if (increase < 0)
    	{
    		System.out.println("No ! Increase value should be positive");
    		increaseWrongValue = true;
    	}
    	//Postcondition : The speed is increased
    	else
    	{
    		if (isOnGround)
    		{
    		speed = Math.min(speed+increase, minSpeed);
    		}
    		else 
    		{
        	speed = speed + increase;
    		}
    	}
       // assert wellFormed();
    }
    
    /*This method decreases the speed of the plane.
     * It takes no parameters and has no return value
     */
    public void throttleDown(int decrease) {
    	int maxSpeed = 140;
    	printStatus();
    	System.out.println("\nThrottling down");
    	//The safe action to take if the preconditions are not respected
    	//is to keep the same speed. If the conditions aren't respected, the if statements
    	//Will be executed and no action will be taken.
    	
    	//Precondition : Speed should always be at least 0
    	if(speed < 0)
    	{
    		System.out.println("No ! Speed should be positive");
    		speedWrongValue = true;
    	}
    	//Precondition : Decrease should always be a positive integer
    	else if(decrease < 0)
    	{
    		System.out.println("No ! Decrease should be a positive value");
    		decreaseWrongValue = true;
    	}
    	//Postcondition : speed is decreased
    	else
    	{
    		if (isOnGround)
    		{
    		speed = Math.max(speed-decrease, 0);
    		}
    		else 
    		{
        	speed = Math.max(speed-decrease, maxSpeed);
    		}
        }
    	
        assert wellFormed();
    }

    /*This method checks if the plane is on the ground
     * @return true if the plane is on the ground
     */
    public boolean isOnGround() {
    	return isOnGround;

    }
    
    /*This method returns the speed of the plane
     * @return speed 
     */
    public int getSpeed() {
    	return speed;
    }
    
    /*This method prints the status of the plane when it's called
     * @param none
     * @return nothing is returned
     */
    void printStatus()
    
    {

    System.out.print("On ground ? ");

    if (isOnGround) //prints yes if the plane id on the ground
    {
    	System.out.print("Yes; ");
    }
    if (!isOnGround)
    {

    	System.out.print("No; ");
    }

    System.out.print("Doors : "); 

    if (doorsOpen) 
    {
    	System.out.print("open; "); //prints open if the doors are open
    }
    if (!doorsOpen)
    {
    	System.out.print("closed; ");
    }

    System.out.print("Wheels : ");

    if (!wheelsUp)
    {
    	System.out.print("down; "); //prints down if the wheels are down
    }
    if (wheelsUp)
    {
    	System.out.print("up; ");
    }

    System.out.print("Speed : " + getSpeed()); //prints the speed
    
    }


    /* Some invariants should always hold. This method checks if it's the case
     * @throws assertionError if it's not the case
     * @return true if the invariants hold
     */
    private boolean wellFormed () {
    			  
    assert !doorsOpenWhileMoving : "Cannot have doors open while moving"; 
    //The doors should never be open while the plane is moving
    	
  	assert !stoppingInTheAir : "Plane cannot stop in the air";
    //The plane should never stop if it's in the air
    	
    assert !stoppingWhileTooFast : "Plane is going fast to stop";
    //The plane should only stop at speed = 20mph
    	
  	assert !taxiInTheAir : "Plane can't taxi in the air";
    //The plane should never taxi in the air
    	
  	assert !doorsOpenInTheAir  : "Doors cannot be open in the air";
    //The doors should never be open when the plane is in the air
    	
  	assert !wheelsUpOnTheGround : "Wheels cannot be up on the ground";
    //Wheels should never be up when the plane is on the ground
    	
 	assert !doorsOpenWhileTaxi : "Plane cannot taxi with doors open";
    //The doors should never open while the plane is moving
 	
 	assert !takingOffFromAir : "Plane cannot takeoff if already in the air";
    //The plane cannot take off if it's already flying
 	
	assert !takingOffWrongSpeed : "Wrong speed for takeoff";
    //The speed to take off should always be 160mph
	
	assert !landingFromGround : "Plane cannot land if it's already on the ground";
    //The plane cannot land if it's already on the ground
	
	assert !landingWrongSpeed : "Wrong speed for landing";
    //The speed should always be 140mph during landing
	
	assert !throttleUpWhileTooSlow : "Speed should at least be 20mph to throttle up";
    //The speed should always be at least 20mph to throttle up 
	
	assert !speedWrongValue  : "Speed cannot be a negative value";
    //The speed should always have a positive value
		
	assert !decreaseWrongValue : "Decrease should be a positive value";
    //Decrease should always be a positive number
	
	assert !increaseWrongValue : "Increase should be a positive value";
    //Increase should always be a positive number


    	
    	return (!doorsOpenWhileMoving && !doorsOpenInTheAir && !wheelsUpOnTheGround 
    			&& !stoppingInTheAir && !stoppingWhileTooFast && !taxiInTheAir
    			&& !doorsOpenWhileTaxi && !takingOffFromAir && !takingOffWrongSpeed
    			&& !landingFromGround && !landingWrongSpeed && !throttleUpWhileTooSlow
    			&& !speedWrongValue && !decreaseWrongValue && !increaseWrongValue);
    	

    	
    }
   
}
