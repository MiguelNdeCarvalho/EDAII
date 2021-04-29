package problem_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem3
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int nPlayers = Integer.parseInt(buffer.readLine());
		int nRule = Integer.parseInt(buffer.readLine());

		if ((nPlayers < 1 || nPlayers > 50) && (nRule < 1 || nRule > 20)) return;

		int[] intervalos = new int[nRule*2];
		long[][] memo = new long[nRule][nPlayers];

		for (int i = 0; i < nRule*2; i += 2)
		{
			String[] max_min_Rule = buffer.readLine().split(" ");

			if (max_min_Rule[0].equals("MIN"))
			{	
				intervalos[i] = Integer.parseInt(max_min_Rule[1]);
				intervalos[i+1] = nPlayers;
			}

			else
			{
				intervalos[i] = 0; 
				intervalos[i+1] = Integer.parseInt(max_min_Rule[1]);
			}
		}
		System.out.println(distribuicao_jogo(nRule, intervalos, nPlayers, memo));
	}

	public static long distribuicao_jogo(int n_pos_por_decidir, int[] intervalos_regras, int n_jogadores_sem_posicao, long[][] memo)
	{
		if (n_pos_por_decidir == 0 && n_jogadores_sem_posicao == 0) return 1;
		
		if (n_pos_por_decidir == 0 && n_jogadores_sem_posicao > 0) return 0;

		if (memo[n_pos_por_decidir - 1][n_jogadores_sem_posicao - 1] != 0) return memo[n_pos_por_decidir - 1][n_jogadores_sem_posicao - 1];

		if (n_pos_por_decidir > 0)
		{
			int minimo = Math.min(intervalos_regras[(n_pos_por_decidir - 1) * 2 + 1], n_jogadores_sem_posicao);

			for (int i = minimo; i >= intervalos_regras[(n_pos_por_decidir - 1) * 2]; i--)
				memo[n_pos_por_decidir - 1][n_jogadores_sem_posicao - 1] += distribuicao_jogo(n_pos_por_decidir - 1, intervalos_regras, n_jogadores_sem_posicao - i, memo);
		}
		return memo[n_pos_por_decidir - 1][n_jogadores_sem_posicao - 1];
	}
}