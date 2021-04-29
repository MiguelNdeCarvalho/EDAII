package problem_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int n_linhas_teclado = Integer.parseInt(buffer.readLine());

		if (n_linhas_teclado > 20) return;

		String[][] teclado = new String[n_linhas_teclado][30];

		for (int i = 0; i < n_linhas_teclado; i++)
		{
			String[] n_linha = buffer.readLine().split("");

			if(n_linha.length > 30) return;

			teclado[i] = n_linha;
		}

		String[] palavra_desejada = buffer.readLine().split("");
		String[] palavra_obtida = buffer.readLine().split("");

		int[][] comp_palavras = new int[palavra_desejada.length][palavra_obtida.length];

		if (palavra_obtida[0].equals("") && ! palavra_desejada[0].equals(""))
		{
			System.out.println(palavra_desejada.length*Math.max(teclado.length, teclado[0].length));
			return;
		}
		System.out.println(func(palavra_desejada.length-1, palavra_obtida.length-1, palavra_desejada, palavra_obtida, comp_palavras, teclado));
	}

	public static int func(int i, int j, String[] palavra_desejada, String[] palavra_obtida, int[][] comp_palavras, String[][] teclado)
	{
		int letra_l_palavra_desejada = teclado.length-1, letra_c_palavra_desejada = teclado[0].length-1, letra_l_palavra_obtida = teclado.length-1, letra_c_palavra_obtida = teclado[0].length-1;

		if (i == -1 && j == -1) return 0;

		if (i == -1 && j > -1) return Integer.MIN_VALUE;

		if(i > -1 && j == -1) return Math.max(teclado.length, teclado[0].length);

		for (int l = 0; l < teclado.length ; l++)
		{
			for (int c = 0; c < teclado[0].length; c++)
			{
				if (teclado[l][c].equals(palavra_desejada[i]))
				{
					letra_l_palavra_desejada = l;
					letra_c_palavra_desejada = c;
				}

				if (teclado[l][c].equals(palavra_obtida[j]))
				{
					letra_l_palavra_obtida = l;
					letra_c_palavra_obtida = c;
				}
			}

			if (teclado[letra_l_palavra_desejada][letra_c_palavra_desejada].equals(palavra_desejada[i]) && teclado[letra_l_palavra_obtida][letra_c_palavra_obtida].equals(palavra_obtida[j]))
			{
				comp_palavras[i][j] += 1 + Math.max(Math.abs(letra_l_palavra_obtida - letra_l_palavra_desejada), Math.abs(letra_c_palavra_obtida - letra_c_palavra_desejada));
				break;
			}
		}
		comp_palavras[i][j] += func(i-1, j-1, palavra_desejada, palavra_obtida, comp_palavras, teclado);
		return comp_palavras[i][j];
	}
}