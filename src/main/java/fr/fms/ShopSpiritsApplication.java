package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class ShopSpiritsApplication implements CommandLineRunner {
	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopSpiritsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//generateDatas();
		//articleRepository.findAll().forEach(a->System.out.println(a));
	}

	private void shop() {

	}

	private void generateDatas() {

		/*
		 * articleRepository.deleteAll(); categoryRepository.deleteAll();
		 * 
		 * Category vodka = categoryRepository.save(new Category(null, "Vodka",
		 * "Une boisson neutre a base de cereales, de pommes de terre ou de betteraves, originaire d'Europe de l'Est et populaire dans le monde entier."
		 * , null)); Category whisky = categoryRepository.save(new Category(null,
		 * "Whisky",
		 * "Un spiritueux distille a base de cereales telles que l'orge, le seigle, le mais ou le ble, vieilli en futs de chene. Les principaux pays producteurs sont l'Ecosse, l'Irlande, les Etats-Unis et le Canada."
		 * , null)); Category rhum = categoryRepository.save(new Category(null, "Rhum",
		 * "Un spiritueux produit a partir de la canne a sucre ou de ses derives, principalement dans les Caraibes et en Amerique latine."
		 * , null)); Category tequila = categoryRepository.save(new Category(null,
		 * "Tequila",
		 * "Une boisson mexicaine fabriquee a partir de l'agave bleu. Elle est souvent consommee en shooter ou utilisee dans les cocktails."
		 * , null)); Category gin = categoryRepository.save(new Category(null, "Gin",
		 * "Un spiritueux aromatise a base de baies de genevrier et d'autres plantes botaniques. Il est apprecie dans les cocktails tels que le gin tonic et le martini."
		 * , null));
		 * 
		 * Article belvedere = articleRepository.save(new Article(null, "Belvedere",
		 * "LVMH",
		 * "Belvedere est une vodka d'exception. Distillee quatre fois a base de seigle d'or de Dankowskie, selon les methodes traditionnelles polonaises, pour un parfait equilibre entre purete et caractere."
		 * , 20, 5, vodka)); Article stolichnaya = articleRepository.save(new
		 * Article(null, "Stolichnaya", "SPI Group",
		 * "Stolichnaya, egalement connue sous le nom de Stoli, est une vodka russe produite a partir de ble et de seigle. Elle est reputee pour sa purete et sa saveur classique."
		 * , 25, 100, vodka)); Article snowLeopard = articleRepository.save(new
		 * Article(null, "Snow Leopard", "Snow Leopard",
		 * "La vodka Snow Leopard est une vodka haut de gamme fabriquee a partir de seigle biologique cultive en Pologne. Elle est distillee et filtree a plusieurs reprises pour obtenir une vodka lisse et raffinee."
		 * , 60, 1, vodka)); Article absolut = articleRepository.save(new Article(null,
		 * "Absolut", "Pernod Ricard",
		 * "L'Absolut Vodka est une vodka suedoise celebre dans le monde entier. Elle est fabriquee a partir d'ingredients naturels et distillee de maniere continue pour obtenir une vodka au gout pur et frais."
		 * , 70, 56, vodka)); Article crystalHead = articleRepository.save(new
		 * Article(null, "Crystal Head", "Crystal Head",
		 * "La vodka Crystal Head est une vodka canadienne elaboree a partir de mais et de l'eau pure de Terre-Neuve. Elle est filtree a plusieurs reprises et distillee en plusieurs etapes pour obtenir une vodka douce et soyeuse."
		 * , 80, 44, vodka)); Article chopin = articleRepository.save(new Article(null,
		 * "Chopin", "Chopin",
		 * "La vodka Chopin est une vodka polonaise artisanale fabriquee a partir de pommes de terre de qualite superieure. Elle est distillee lentement et filtree pour obtenir une vodka raffinee et veloutee."
		 * , 30, 35, vodka));
		 * 
		 * Article theMacallan = articleRepository.save(new Article(null,
		 * "The Macallan", "Macallan Distillers Ltd",
		 * "The Macallan est une distillerie de whisky ecossaise reputee pour produire des single malts de haute qualite. Leur whisky est vieilli dans des futs de chene espagnols qui lui conferent des aromes riches et complexes."
		 * , 35, 10, whisky)); Article glenfiddich = articleRepository.save(new
		 * Article(null, "Glenfiddich", "William Grant & Sons Ltd",
		 * " Glenfiddich est une distillerie de whisky ecossaise qui propose une large gamme de single malts. Leur whisky est vieilli dans des futs de chene americains et espagnols, offrant une combinaison d'aromes fruites et epices."
		 * , 85, 200, whisky)); Article ardbeg = articleRepository.save(new
		 * Article(null, "Ardbeg", "Ardbeg Distillery Ltd",
		 * "rdbeg est une distillerie de whisky situee sur l'ile d'Islay en Ecosse, connue pour produire des single malts tourbes et fumes. Leur whisky est vieilli dans des futs de bourbon, ce qui lui confere des saveurs intenses et maritimes."
		 * , 75, 70, whisky)); Article lagavulin = articleRepository.save(new
		 * Article(null, "Lagavulin", "Lagavulin Distillery Co",
		 * "Lagavulin est une distillerie de whisky ecossaise reputee pour ses single malts tourbes et fumes. Leur whisky est vieilli dans des futs de chene, ce qui lui donne des notes riches de tourbe, de fumee et de fruits secs."
		 * , 25, 40, whisky)); Article talisker = articleRepository.save(new
		 * Article(null, "Talisker", "Talisker Distillery",
		 * "Talisker est une distillerie de whisky situee sur l'ile de Skye en Ecosse. Leur whisky est connu pour son caractere fume et maritime, avec des notes de poivre et de fruits secs."
		 * , 99, 500, whisky));
		 * 
		 * Article ronZacapa = articleRepository.save(new Article(null, "Ron Zacapa",
		 * "Zacapa Distillery",
		 * "Ron Zacapa est une marque de rhum originaire du Guatemala, reputee pour son processus de vieillissement complexe et sa qualite exceptionnelle. Leurs rhums sont vieillis selon le systeme solera et presentent des saveurs riches, sucrees et epicees."
		 * , 99, 500, whisky)); Article diplomatico = articleRepository.save(new
		 * Article(null, "Diplomatico", "Destilerias Unidas S.A.",
		 * "Diplomatico est une marque de rhum du Venezuela, appreciee pour ses methodes de production artisanales et son gout riche et complexe. Leurs rhums sont vieillis dans une combinaison de futs de bourbon et de xeres, offrant des aromes de caramel, de chocolat et de fruits tropicaux."
		 * , 99, 500, whisky)); Article appletonEstate = articleRepository.save(new
		 * Article(null, "Appleton Estate", "J. Wray & Nephew Ltd",
		 * "Appleton Estate est une marque de rhum jamaicain, reputee pour son heritage et sa production traditionnelle. Leurs rhums sont vieillis dans des futs de chene et presentent des notes d'epices, de fruits murs et de melasse.\n"
		 * + "Prix : Varie en fonction de l'expression specifique et de l'age du rhum.",
		 * 99, 500, whisky)); Article havanaClub = articleRepository.save(new
		 * Article(null, "Havana Club", "Havana Club International S.A.",
		 * "Havana Club est une marque de rhum cubain, reconnue dans le monde entier pour son authenticite et son savoir-faire. Leurs rhums sont fabriques a partir de melasse et vieillis dans des futs de chene, offrant des aromes doux, epices et legerement fumes."
		 * , 99, 500, whisky));
		 */

	}

}
