import java.util.Set;

public class ArrayInteger
{
	/**
	 * find all prime numbers up to given limit using sieve of Eratosthenes algorithm
	 * n: given limit
	 * return a boolean array has n elements represent for "is prime number" number of correspoding index   
	 */
	public static boolean[] sievePrime(int n)
	{
		boolean[] isPrime = new int[n + 1];

		for(int i = 2; i <= n; i++)
		{
			isPrime[i] = true;
		}

		for(int i = 2; i <= n; i++)
		{
			if(!isPrime[i])
			{
				continue;
			}

			for(int j = 2 * i; j <= n; j += i)
			{
				isPrime[j] = false;
			}
		}

		return isPrime;
	}
	

}
