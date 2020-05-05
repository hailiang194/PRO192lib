import java.lang.Math;

public class ExtraMath
{
	/**
	 * get x ^ y
	 * x: base
	 * y: power
	 * throw "y must be positive" then y is less than 0, because this method return long data type
	 * throw "pow is too big" when x ^ y is out of range
	 */
	public static long pow(int x, int y)
	{
		if(y < 0)
		{
			throw new ArithmeticException("y must be positive");
		}

		long p = 1;

		for(int i = 0; i < y; i++)
		{
			p *= x;
			if(p < 0)
			{
				throw new ArithmeticException("pow is too big");
			}
		}

		return p;
	}

	/**
	 * get the factorial of n
	 * n: the number you want to get factorial
	 * throw "n must be positive" if n is less than 0 
	 * throw "factorial is too big" if factorial is too big
	 * return n!
	 */
	public static long fact(int n)
	{

		if(n < 0)
		{
			throw new ArithmeticException("n must be positive");
		}
		
		//because long can store n! with n <= 20	
		if(n > 20)
		{
			throw new ArithmeticException("factorial is too big");
		}

		long f = 1;
		
		for(int i = 2; i <= n; i++)
		{
			f *= i;
		}
		
		return f;	
	}
	
	/**
	 * calculate the k-combination of set of n 
	 * n: the length of set
	 * k: the length of subset of distinct elements
	 * throw "the length of subset must be less than the length of set" if k is greater than n
	 * return the k-combination of set of n
	 */
	public static long nCk(int n, int k)
	{
		if(k > n)
		{
			throw new ArithmeticException("the length of subset must be less than the length of set");
		}

		return fact(n) / (fact(k) * fact(n - k));
	}

	/**
	 * calculate the greatest common divisor of a and b
	 * a: the first positive integer
	 * b: the second positive integer
	 * throw "two integer must be positive and not zero" if a or b is negative or zero
	 * return the greatest common divisor of a and b
	 */
	public static int GCD(int a, int b)
	{
		if((a <= 0) || (b <= 0))
		{
			throw new ArithmeticException("two integer must be positive and not zero");
		}

		while(a != b)
		{
			if(a > b)
			{
				a -= b;
			}
			else
			{
				b -= a;
			}
		}

		return a;
	}

	/**
	 * calculate the lowest common multiple of a and b
	 * a: the first positive integer
	 * b: the second positive integer
	 * throw "two integer must be positive and not zero" if a or b is negative or zero
	 * return the lowest common multiple of a and b
	 */
	public static int LCM(int a, int b)
	{
		if((a <= 0) || (b <= 0))
		{
			throw new ArithmeticException("two integer must be positive and not zero");
		}

		return (a * b) / GCD(a, b);
	}

	/**
	 * Check if n is prime number
	 * n: an integer you want to check
	 * return true if n is prime number, otherwise false
	 */
	public static boolean isPrime(int n)
	{
		if(n < 2)
		{
			return false;
		}

		//all even number except 2 are not prime numbers
		if(n == 2)
		{
			return true;
		}

		if(n % 2 == 0)
		{
			return false;
		}

		for(int i = 3; i <= Math.sqrt(n); i += 2)
		{
			if(n % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Check if n is square number of not
	 * n: an integer you want to check
	 * return true if n is square number, otherwise false
	 */
	public static boolean isSquareNumber(int n)
	{
		if(n < 0)
			return false;

		final int SQUARE_ROOT = (int)Math.sqrt(n);

		return (SQUARE_ROOT * SQUARE_ROOT == n);
	}
	
	/**
	 * get next prime number after n
	 * n: the start integer
	 * throw "Can\'t find next prime number" if n is too big to find next prime number
	 * return prime number after n 
	 */
	public static int nextPrimeNumber(int n)
	{
		if(n < 2)
			return 2;

		final int START = (n % 2 == 0) ? (n + 1) : (n + 2);

		for(int i = START; true; i += 2)
		{
			if(i < 0)
			{
				throw new ArithmeticException("Can\'t find next prime number");
			}

			if(isPrime(i))
				return i;
		}

		//this will never happen
		return 0;
	}

	/**
	 * Check if n is perfect number
	 * n: an positive integer you want to check
	 * return true if n is perfect number, otherwise false
	 */
	public static boolean isPerfectNumber(int n)
	{
		int divSum = 0;

		for(int i = 2; i <= sqrt(n); i++)
		{
			if(n % i == 0)
			{
				divSum += (i + n / i);
			}
		}

		return (divSum == n);
	}
}
