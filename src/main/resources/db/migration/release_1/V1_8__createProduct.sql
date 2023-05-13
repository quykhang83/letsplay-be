CREATE TABLE PUBLIC.Products (
    productId bigserial NOT NULL,
    productName VARCHAR(250) NOT NULL,
    productPrice NUMERIC(10, 2) NOT NULL,
    productDescription VARCHAR(250) NOT NULL,
    productTypeId bigint NOT NULL,
    productCapacity NUMERIC(10, 2) NOT NULL,
    productDownloads bigint NOT NULL DEFAULT 0,
    primary key (productId)
);

CREATE TABLE PUBLIC.ProductTypes (
    productTypeId bigserial NOT NULL,
    productTypeName VARCHAR(250) NOT NULL,
    productTypeDescription VARCHAR(250) NOT NULL,
    primary key (productTypeId)
);

ALTER TABLE PUBLIC.Products
ADD CONSTRAINT producttype_id_fk FOREIGN KEY (productTypeId) REFERENCES ProductTypes (productTypeId);

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('#', 'Product with no type');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('On Sale', 'Sports games have expanded in variety, offering full-fledged partnerships with major sporting organizations');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Feature & Recommended', 'The shooter is another long-standing genre that developed several early offshoots');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Best With Friends', 'Puzzlers and party games also have a significant overlap, with both emphasizing game mechanics');



INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Among Us', '49000','An online and local party game of teamwork and betrayal for 4-15 players...in space!', '2', '80', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('DORAEMON STORY OF SEASONS', '550000','Japan''s adored Doraemon meets Story of Seasons in this new, fresh take on farming, now on Let''s Play! The setting is Natura, and the theme is creating bonds. While doing so, enjoy the heartwarming interactions through each character in the story!', '4', '300.2', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('DRAGON BALL Z: KAKAROT', '800000','Relive the story of Goku and other Z Fighters in DRAGON BALL Z: KAKAROT! Beyond the epic battles, experience life in the DRAGON BALL Z world as you fight, fish, eat, and train with Goku, Gohan, Vegeta and others.', '3', '12000', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('EA SPORTS FIFA 23', '1090000','FIFA 23 brings The World''s Game to the pitch, with HyperMotion2 Technology, men''s and women''s FIFA World Cup™coming during the season, women''s club teams, cross-play features*, and more.', '4', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('God of War', '1139000','His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.', '3', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Little Nightmares', '298000','Immerse yourself in Little Nightmares, a dark whimsical tale that will confront you with your childhood fears! Help Six escape The Maw - a vast, mysterious vessel inhabited by corrupted souls looking for their next meal.', '3', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Ori and the Will of the Wisps', '250000','Play the critically acclaimed masterpiece. Embark on a new journey in a vast, exotic world where you''ll encounter towering enemies and challenging puzzles on your quest to unravel Ori''s destiny.', '2', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Oxygen Not Included', '220000','Oxygen Not Included is a space-colony simulation game. Deep inside an alien space rock your industrious crew will need to master science, overcome strange new lifeforms, and harness incredible space tech to survive, and possibly, thrive.', '4', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Car Mechanic Simulator 2021', '321000','Work your way to a service empire. Get your hands dirty in a highly realistic simulation game that pays major attention to details. Pay a visit to a new Auction house and buy cars in various conditions.', '4', '900', '999');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Plane Mechanic Simulator', '140000','England - 1940. The Luftwaffe is preparing for the invasion of Britain and the RAF need every man to stop it. They need you. Join the ground crews as they struggle to keep the aircraft flying.', '4', '880', '777');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Abandon Ship', '321000','Take command of an Age of Sail ship and her crew, exploring a vast, story-filled world that reacts to your decisions. Engage enemy vessels, fortifications and sea monsters in brutal tactical combat.', '4', '500', '700');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('RetroSpace', '987000','A disco-punk space-horror, where you can be a sneaky chap or a crazy mutant action hero on a space station swallowed by a black hole. Prepare for weird creatures, immersive features, time jumps, and 70s mustaches!', '2', '600', '705');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('World War Z', '445000','World War Z is a heart-pounding coop third-person shooter for up to 4 players featuring massive swarms of hundreds of zombies, focused on fast-paced, gruesomely spectacular action.', '3', '672', '789');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('AstroBike', '20000','Prepare your mind and skills for a challenging and addictive motorbike racing game. Collect every emerald - or the one challenging diamond - in each track and then head for the black hole.', '4', '100', '780');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Meow Express', '15000','You are a cat on a robot vacuum cleaner. Which means you are bus driver in the cat world! Dodge obstacles, pop innocent kids baloons, dash through buildings to collect your fellow cat pussengers.', '3', '56', '230');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Ice Lakes', '165000','Ice Lakes is a modern ice fishing simulator with different single and multiplayer game modes and sandbox approach to wintertime fishing. Use and customize wide selection of fishing gear and learn how changing season, bottom topology.', '2', '500', '463');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('ICE FLAME', '155000','ICE FLAME - an exciting game about the adventures of an incredible cat who travels in search of magical fire through an icy mountain. However, on the way to his goal!', '3', '600', '804');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Bay Bell', '75000','A science fiction point and click word puzzle game. Navigate an off-course spaceship, and find a way toward returning home. The end is near… Can you save the Bay Bell?', '2', '300', '423');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Out of the Park Baseball 24', '470000','Play What The Pros Play! Officially licensed by MLB, the MLB Players Inc., and KBO, Out of the Park Baseball 24 is the newest in the award-winning sports strategy series. A sports fans dream come true.', '4', '720', '932');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Marvels Spider-Man Remastered', '1139000','In Marvels Spider-Man Remastered, the worlds of Peter Parker and Spider-Man collide in an original action-packed story. Play as an experienced Peter Parker, fighting big crime and iconic villains in Marvels New York.', '2', '980', '785');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Marvels Guardians of the Galaxy', '1499000','Fire up a wild ride across the cosmos with a fresh take on Marvels Guardians of the Galaxy. In this action-adventure game, you are Star-Lord leading the unpredictable Guardians from one explosion of chaos to the next.', '2', '963', '753');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Kingdoms Reborn', '188000','A city builder with simulated citizens, set in a procedurally-generated world map. Grow your kingdom through the eras from a tiny medieval hamlet into a prosperous global empire! Cooperate or compete in real-time with your friends.', '3', '563', '456');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('SD GUNDAM BATTLE ALLIANCE', '1280000','SD Gundam Battle Alliance is a multiplayer Gundam action RPG where you can smash foes solo or with friends in thrilling mechanized combat. Acquire new mobile suits, power them up, and take them into battle in various missions!', '3', '969', '830');


-- New Product 24 - 38
INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('DRAGON BALL FighterZ', '1080000','DRAGON BALL FighterZ is born from what makes the DRAGON BALL series so loved and famous: endless spectacular fights with its all-powerful fighters.', '1', '100', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Forza Horizon 4', '480000','Dynamic seasons change everything at the world''s greatest automotive festival. Go it alone or team up with others to explore beautiful and historic Britain in a shared open world.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Grand Theft Auto V', '311000','Grand Theft Auto V for PC offers players the option to explore the award-winning world of Los Santos and Blaine County in resolutions of up to 4k and beyond, as well as the chance to experience the game running at 60 frames per second.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Gunfire Reborn', '260000','Gunfire Reborn is a level-based adventure game featuring FPS, Roguelite and RPG. Players can control heroes with various abilities to experience diverse Build gameplay, use various weapons to explore procedurally-generated levels.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Hogwarts Legacy', '990000','Hogwarts Legacy is an immersive, open-world action RPG. Now you can take control of the action and be at the center of your own adventure in the wizarding world.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Minecraft Dungeons', '450000','Fight your way through an exciting action-adventure game, inspired by classic dungeon crawlers and set in the Minecraft universe!', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Minecraft Legends', '890000','Discover the mysteries of Minecraft Legends, a new action strategy game. Explore a gentle land of rich resources and lush biomes on the brink of destruction. The ravaging piglins have arrived.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('ONE PIECE ODYSSEY', '680000','A brand new RPG set in the world of the popular anime, ONE PIECE! Play as members of the Straw Hat Crew in a fantastic adventure set in the ONE PIECE world!', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('ONE PIECE PIRATE WARRIORS 4', '800000','ONE PIECE: PIRATE WARRIORS 4 is the latest evolution of PIRATE WARRIORS action! Based on the concept of "experiencing a real ONE PIECE battlefield," buildings will come crashing down during the action and attacks will throw up smoke and dust.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Ori and the Blind Forest', '490000','“Ori and the Blind Forest” tells the tale of a young orphan destined for heroics, through a visually stunning action-platformer crafted by Moon Studios for PC.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Return to Monkey Island', '321000','Return to Monkey Island is an unexpected, thrilling return of series creator Ron Gilbert that continues the story of the legendary adventure games.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('STAR WARS Jedi: Survivor', '1090000','The story of Cal Kestis continues in STAR WARS Jedi: Survivor™, a galaxy-spanning, third-person, action-adventure game.', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('The Escapists', '200000','The Escapists provides players the opportunity of experiencing a light-hearted insight into everyday prison life with the main objective being that of escaping!', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('The Escapists 2', '400000','Craft, Steal, Brawl and Escape! It''s time to bust out of the toughest prisons in the world as you return to the life of an inmate in The Escapists 2, now with multiplayer! Have you got what it takes to escape?', '1', '2000', '1200');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('The Last Spell', '321000','Defend the last bastion of humanity with your squad of heroes! Exterminate fiendish monsters with magic and brute force by night and re-build your battered city defenses by day in this tactical RPG with rogue-lite mechanics.', '1', '2000', '1200');