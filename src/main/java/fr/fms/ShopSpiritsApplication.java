package fr.fms;

import fr.fms.entities.Article;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;

@SpringBootApplication
public class ShopSpiritsApplication implements CommandLineRunner {
	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopSpiritsApplication.class, args);
	}
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		//generateDatas();
		//articleRepository.findAll().forEach(System.out::println);
	}

	private void shop() {
		// Code de votre méthode shop()
	}

	private void generateDatas() {

		articleRepository.deleteAll();
		categoryRepository.deleteAll();

		Category gin = categoryRepository.save(new Category(null, "Gin", "Un spiritueux aromatise a base de baies de genevrier et d'autres plantes botaniques. ", null));
		Category vodka = categoryRepository.save(new Category(null, "Vodka", "Une boisson neutre a base de cereales, de pommes de terre ou de betteraves", null));
		Category whisky = categoryRepository.save(new Category(null, "Whisky", "Un spiritueux distille a base de cereales telles que l'orge, le seigle, le mais ou le ble", null));
		Category rhum = categoryRepository.save(new Category(null, "Rhum", "Un spiritueux produit a partir de la canne a sucre ou de ses derives, principalement dans les Caraibes et en Amerique latine.", null));
		Category tequila = categoryRepository.save(new Category(null, "Tequila", "Une boisson mexicaine fabriquee a partir de l'agave bleu. Elle est souvent consommee en shooter ou utilisee dans les cocktails.", null));

		Article belvedere = articleRepository.save(new Article(null, "Belvedere", "LVMH", "Belvedere est une vodka d'exception. Distillee quatre fois a base de seigle d'or de Dankowskie.", 20, 5, vodka, null));
		Article stolichnaya = articleRepository.save(new Article(null, "Stolichnaya", "SPI Group", "Stolichnaya, egalement connue sous le nom de Stoli, est une vodka russe produite a partir de ble et de seigle.", 25, 100, vodka, null));
		Article snowLeopard = articleRepository.save(new Article(null, "Snow Leopard", "Snow Leopard", "La vodka Snow Leopard est une vodka haut de gamme fabriquee a partir de seigle biologique cultive en Pologne.", 60, 1, vodka, null));
		Article absolut = articleRepository.save(new Article(null, "Absolut", "Pernod Ricard", "L'Absolut Vodka est une vodka suedoise celebre dans le monde entier.", 70, 56, vodka, null));
		Article crystalHead = articleRepository.save(new Article(null, "Crystal Head", "Crystal Head", "La vodka Crystal Head est une vodka canadienne elaboree a partir de mais et de l'eau pure de Terre-Neuve.", 80, 44, vodka, null));
		Article chopin = articleRepository.save(new Article(null, "Chopin", "Chopin", "La vodka Chopin est une vodka polonaise artisanale fabriquee a partir de pommes de terre de qualite superieure.", 30, 35, vodka, null));

		Article theMacallan = articleRepository.save(new Article(null, "The Macallan", "Macallan Distillers Ltd", "The Macallan est une distillerie de whisky ecossaise reputee pour produire des single malts de haute qualite. ", 35, 10, whisky, null));
		Article glenfiddich = articleRepository.save(new Article(null, "Glenfiddich", "William Grant & Sons Ltd", " Glenfiddich est une distillerie de whisky ecossaise qui propose une large gamme de single malts.", 85, 200, whisky, null));
		Article ardbeg = articleRepository.save(new Article(null, "Ardbeg", "Ardbeg Distillery Ltd", "rdbeg est une distillerie de whisky situee sur l'ile d'Islay en Ecosse, connue pour produire des single malts tourbes et fumes. ", 75, 70, whisky, null));
		Article lagavulin = articleRepository.save(new Article(null, "Lagavulin", "Lagavulin Distillery Co", "Lagavulin est une distillerie de whisky ecossaise reputee pour ses single malts tourbes et fumes. ", 25, 40, whisky, null));
		Article talisker = articleRepository.save(new Article(null, "Talisker", "Talisker Distillery", "Talisker est une distillerie de whisky situee sur l'ile de Skye en Ecosse. ", 99, 500, whisky, null));

		Article ronZacapa = articleRepository.save(new Article(null, "Ron Zacapa", "Zacapa Distillery", "Ron Zacapa est une marque de rhum originaire du Guatemala, reputee pour son processus de vieillissement complexe et sa qualite exceptionnelle.", 99, 500, rhum, null));
		Article diplomatico = articleRepository.save(new Article(null, "Diplomatico", "Destilerias Unidas S.A.", "Diplomatico est une marque de rhum du Venezuela, appreciee pour ses methodes de production artisanales et son gout riche et complexe.", 99, 500, rhum, null));
		Article appletonEstate = articleRepository.save(new Article(null, "Appleton Estate", "J. Wray & Nephew Ltd", "Appleton Estate est une marque de rhum jamaicain, reputee pour son heritage et sa production traditionnelle. Leurs rhums sont vieillis dans des futs de chene ", 99, 500, rhum, null));
		Article havanaClub = articleRepository.save(new Article(null, "Havana Club", "Havana Club International S.A.", "Havana Club est une marque de rhum cubain, reconnue dans le monde entier pour son authenticite et son savoir-faire.", 99, 500, rhum, null));
	}
}