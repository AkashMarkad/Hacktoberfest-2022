//Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The mission is to move all the disks to some another tower without violating the sequence of arrangement. A few rules to be followed for Tower of Hanoi are −

// Only one disk can be moved among the towers at any given time.
// Only the "top" disk can be removed.
// No large disk can sit over a small disk.



// Java recursive program to solve tower of hanoi puzzle

class Towerofhanoi
{
	// Java recursive function to solve tower of hanoi puzzle
	static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
	{
		if (n == 1)
		{
			System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
			return;
		}
		towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
		System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
		towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
	}
	
	// Driver method
	public static void main(String args[])
	{
		int n = 4; // Number of disks
		towerOfHanoi(n, \'A\', \'C\', \'B\'); // A, B and C are names of rods
	}
}
