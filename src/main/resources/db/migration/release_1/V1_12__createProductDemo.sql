CREATE TABLE PUBLIC.ProductDemos (
    productDemoId bigserial NOT NULL,
    productDemoTitle VARCHAR(250) NOT NULL,
    productDemoUrl VARCHAR(400) NOT NULL,
    productId bigint NOT NULL,
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId),
    primary key (productDemoId)
);

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAmong%20Us%2F1.jpg?alt=media&token=0a47d774-1037-4355-beb8-f05c8debf17b', '1');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAmong%20Us%2F2.jpg?alt=media&token=191d136d-b384-4955-a15e-2be7163950bf', '1');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAmong%20Us%2F3.jpg?alt=media&token=681dab6b-5e0d-4ca4-8f58-2ccfd314faeb', '1');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/m4smMkGbhHw" title="Among Us Hide n Seek Mode - OUT NOW | Emergency Meeting #35" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '1');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDORAEMON%20STORY%20OF%20SEASONS%2F1.jpg?alt=media&token=55b8a717-dadd-48fb-b6ad-ead37004039f', '2');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDORAEMON%20STORY%20OF%20SEASONS%2F2.jpg?alt=media&token=940ec5d3-d330-4159-ac2f-0040b86389fd', '2');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDORAEMON%20STORY%20OF%20SEASONS%2F3.jpg?alt=media&token=d791b01f-80a1-4e31-9064-26dff38eefbb', '2');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/YuKO0tUVoQI" title="Doraemon: Story of Seasons - Launch Trailer - Nintendo Switch" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '2');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDragon%20Ball%20Z%3A%20Kakarot%2F1.jpg?alt=media&token=550f9e19-1053-4ccc-9233-81182589a927', '3');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDragon%20Ball%20Z%3A%20Kakarot%2F2.jpg?alt=media&token=b34b72cd-44df-48af-81e9-93c6d8e5140e', '3');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDragon%20Ball%20Z%3A%20Kakarot%2F3.jpg?alt=media&token=c20a5084-8255-4f9c-b70d-2be5c20e4e64', '3');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/Bf85wwJuFBE" title="Dragon Ball Z: Kakarot - Launch Trailer - PS4/XB1/PC" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '3');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FEA%20SPORTS%E2%84%A2%20FIFA%2023%2F1.jpg?alt=media&token=912ada39-8373-4550-a148-db96ef97054c', '4');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FEA%20SPORTS%E2%84%A2%20FIFA%2023%2F2.jpg?alt=media&token=5a0940c0-41e6-4a25-a240-30f2df1307f3', '4');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FEA%20SPORTS%E2%84%A2%20FIFA%2023%2F3.jpg?alt=media&token=6fabe79e-f590-4e0d-9193-0063d6e5bad5', '4');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/o3V-GvvzjE4" title="FIFA 23 Reveal Trailer | The World’s Game" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '4');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGod%20of%20War%2F1.jpg?alt=media&token=765810cf-53cd-42f6-9f51-be0821b4b565', '5');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGod%20of%20War%2F2.jpg?alt=media&token=6eafc666-a227-4777-acb2-8ed7856f885d', '5');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGod%20of%20War%2F3.jpg?alt=media&token=3d1a06ee-bde2-4fc1-8d48-a869a439bed5', '5');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/HqQMh_tij0c" title="God of War – Announce Trailer | PC" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '5');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FLittle%20Nightmares%2F1.jpg?alt=media&token=e77c916c-6161-4018-93f6-520ec1097fcb', '6');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FLittle%20Nightmares%2F2.jpg?alt=media&token=b2905bda-7439-4a04-8fb9-03f94188af6f', '6');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FLittle%20Nightmares%2F3.jpg?alt=media&token=6015cd17-5876-4986-b8c6-7c12d9bd2aac', '6');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/y27KjX_FRk4" title="Little Nightmares - Deep Below the Waves Trailer | PS4, XB1, PC" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '6');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOri%20and%20the%20Will%20of%20the%20Wisps%2F1.jpg?alt=media&token=a6646735-48f3-4854-91aa-12fb49927c63', '7');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOri%20and%20the%20Will%20of%20the%20Wisps%2F2.jpg?alt=media&token=3481702b-6455-46fb-bc3e-c6894e6e824f', '7');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOri%20and%20the%20Will%20of%20the%20Wisps%2F3.jpg?alt=media&token=9512dc58-4819-4713-b11f-4fa248e1da6b', '7');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/NJoWjtp-EIc" title="Ori and the Will of the Wisps Accolades Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '7');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOxygen%20Not%20Included%2F1.jpg?alt=media&token=ed4cb036-4117-4a5a-a7ec-ea37a997805a', '8');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOxygen%20Not%20Included%2F2.jpg?alt=media&token=1829c349-d92b-4919-895d-39b2da91398a', '8');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOxygen%20Not%20Included%2F3.jpg?alt=media&token=162f73b1-0e0b-4387-87c7-f4020514b276', '8');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/wcLayGm_pM4" title="Oxygen Not Included [Official Launch Trailer]" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '8');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FCar%20Mechanic%20Simulator%202021%2F1.jpg?alt=media&token=fd3f0c3c-5ec6-41b0-a599-af54b35cf1fd', '9');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FCar%20Mechanic%20Simulator%202021%2F2.jpg?alt=media&token=250fba07-d4f7-4ed9-965f-83ebf51af071', '9');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FCar%20Mechanic%20Simulator%202021%2F3.jpg?alt=media&token=532aec8d-2471-450c-92ee-0b8243cad769', '9');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/9nxIEgWNLhc" title="Car Mechanic Simulator 2021 - Game Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '9');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FPlane%20Mechanic%20Simulator%2F1.jpg?alt=media&token=9125a380-e86b-4571-8967-62c599e0ecc1', '10');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FPlane%20Mechanic%20Simulator%2F2.jpg?alt=media&token=980f6f9d-81a3-4d2f-bb92-48717181dd32', '10');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FPlane%20Mechanic%20Simulator%2F3.jpg?alt=media&token=5ec56300-3ee5-4c05-8d6e-f17109dab382', '10');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/67RCXTBPDhU" title="Plane Mechanic Simulator - Launch Trailer (Available NOW on Steam!)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '10');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAbandon%20Ship%2F1.jpg?alt=media&token=0bb02bdb-0cca-4be9-a62d-42d1976eb77f', '11');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAbandon%20Ship%2F2.jpg?alt=media&token=79cfc7b5-a1ff-43cf-97a3-eeac154ede0f', '11');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAbandon%20Ship%2F3.jpg?alt=media&token=0164af47-e539-4a6b-b8e0-354408d5ece6', '11');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/ajyT1Yulw40" title="Abandon Ship: Announcement Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '11');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FRetroSpace%2F1.jpg?alt=media&token=e3b6e3c9-3ed6-4279-8b92-331bd71bbfad', '12');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FRetroSpace%2F2.jpg?alt=media&token=5c96f603-7d9f-4398-877f-b1167367efb2', '12');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FRetroSpace%2F3.jpg?alt=media&token=9b9caf27-b180-4bac-9577-23602b3fc327', '12');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/fdZROhrwMjQ" title="RetroSpace - Official Reveal Teaser" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '12');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FWorld%20War%20Z%2F1.jpg?alt=media&token=ac75808a-581f-4a54-96d5-1730b359ffac', '13');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FWorld%20War%20Z%2F2.jpg?alt=media&token=ac13a95a-ec4b-4e50-b65c-6f1eea6ec62b', '13');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FWorld%20War%20Z%2F3.jpg?alt=media&token=a1660fc9-cde5-4d6d-926a-96f996ce7a35', '13');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/YZ3Dx4tfirE" title="World War Z - Launch Trailer | PS4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '13');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAstroBike%2F1.jpg?alt=media&token=dd0d2798-5483-4f76-902d-701719843312', '14');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAstroBike%2F2.jpg?alt=media&token=1765bfb3-e035-419b-8644-612117782d75', '14');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FAstroBike%2F3.jpg?alt=media&token=89b0a810-4554-4633-8a25-5621ac2bd2b3', '14');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/7tC2YrkDA7o" title="AstroBike Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '14');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMeow%20Express%2F1.jpg?alt=media&token=65e9f707-9a25-4189-9536-78e62d646b75', '15');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMeow%20Express%2F2.jpg?alt=media&token=ebbec272-c908-44d6-b590-c8a749a9d9b8', '15');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMeow%20Express%2F3.jpg?alt=media&token=ead77074-8499-4c76-86f0-2b05ff9fa4cd', '15');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/hB3EqIyhZ8s?list=PL-GOXiiZimJVh8ymxBsbCiDfonhqBGlwz" title="Meow Express Trailer | An indie game about cats and public transport!" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '15');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FIce%20Lakes%2F1.jpg?alt=media&token=634ab8e7-33f4-4751-bbda-86b218757352', '16');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FIce%20Lakes%2F2.jpg?alt=media&token=f876ed6b-5098-4b74-af35-344b18260439', '16');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FIce%20Lakes%2F3.jpg?alt=media&token=27f394ea-b9a6-4142-9f4a-e8ab57dc364c', '16');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/iUruw86EHLk" title="Ice Lakes Launch Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '16');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FICE%20FLAME%2F1.jpg?alt=media&token=b5f5ae88-a5cf-44ca-9cf9-2484a49a441d', '17');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FICE%20FLAME%2F2.jpg?alt=media&token=b9c618c2-b781-4e23-998a-479f891ca1ef', '17');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FICE%20FLAME%2F3.jpg?alt=media&token=b7095405-31d7-4351-a907-d17212136a12', '17');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/uzWX9UuZa1Y" title="Frozen Flame - Official Early Access Launch Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '17');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FBay%20Bell%2F1.jpg?alt=media&token=f0e14aaf-3514-48ac-beb2-622262efb71e', '18');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FBay%20Bell%2F2.jpg?alt=media&token=ee1c4f3b-02b8-4e80-863e-c2dcd6f997b2', '18');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FBay%20Bell%2F3.jpg?alt=media&token=eb5f8420-c06b-46eb-a481-854d03c44b22', '18');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/nFmQqUxH7GA" title="War Drums Music - Drums of the Horde" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '18');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOut%20of%20the%20Park%20Baseball%2024%2F1.jpg?alt=media&token=b9803af4-78c3-4c8b-924a-76fbf1380512', '19');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOut%20of%20the%20Park%20Baseball%2024%2F2.jpg?alt=media&token=f28fc9d2-3829-4757-a54c-3d5f8d5ee156', '19');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOut%20of%20the%20Park%20Baseball%2024%2F3.jpg?alt=media&token=c68bcb82-712d-476d-8691-5ae0f91e0a05', '19');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/0NqMwR3IIAg" title="Out of the Park Baseball 24 - Full Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '19');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMarvel%E2%80%99s%20Spider-Man%20Remastered%2F1.jpg?alt=media&token=b8e7344a-8323-4788-bcce-d4da02259196', '20');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMarvel%E2%80%99s%20Spider-Man%20Remastered%2F2.jpg?alt=media&token=4f4b1ae0-0726-4968-8149-19413b8100a0', '20');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMarvel%E2%80%99s%20Spider-Man%20Remastered%2F3.jpg?alt=media&token=515c184f-2655-44f3-a07c-12460c687be4', '20');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/mrT5q5xXb7Y" title="Marvels Spider-Man Remastered | PC Launch Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '20');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMarvels%20Guardians%20of%20the%20Galaxy%2F1.jpg?alt=media&token=77d43b95-bdbc-48e5-ab96-4acf54a6c349', '21');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMarvels%20Guardians%20of%20the%20Galaxy%2F2.jpg?alt=media&token=e20cfbb6-4315-4d9d-a8b6-61581b8bfbe5', '21');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMarvels%20Guardians%20of%20the%20Galaxy%2F3.jpg?alt=media&token=ce1fb089-109d-40d8-b572-dc5f6d7c639f', '21');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/Q0fdMDwhVzk" title="Official Launch Trailer | Marvels Guardians of the Galaxy | Marvel Games" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '21');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FKingdoms%20Reborn%2F1.jpg?alt=media&token=9c119855-aed5-49a9-b9b4-779bcd4e0e9a', '22');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FKingdoms%20Reborn%2F2.jpg?alt=media&token=15b1c660-34b4-46da-9e66-e350f53d00d6', '22');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FKingdoms%20Reborn%2F3.jpg?alt=media&token=391eb7e2-5d68-45c3-92d4-e6a612562119', '22');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/8qtzfju1Izk" title="Kingdoms Reborn - Trailer | City-builder with Multiplayer and Open World" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '22');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FSD%20GUNDAM%20BATTLE%20ALLIANCE%2F1.jpg?alt=media&token=20916d2b-1332-44e9-b47d-9781986b9342', '23');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FSD%20GUNDAM%20BATTLE%20ALLIANCE%2F2.jpg?alt=media&token=37089c94-4db4-435a-a319-9fb8e4a02e28', '23');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FSD%20GUNDAM%20BATTLE%20ALLIANCE%2F3.jpg?alt=media&token=d68fe44f-4619-46eb-8984-c934236ece68', '23');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/Kmb8pUQBqTc" title="SD Gundam Battle Alliance - Announcement Trailer - Coming 2022" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '23');

-- New product from 24 - 38
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDRAGON%20BALL%20FighterZ%2F1.jpg?alt=media&token=637bb778-286f-4054-85f7-814f3782fbde', '24');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDRAGON%20BALL%20FighterZ%2F2.jpg?alt=media&token=97be2022-8538-4933-a56e-81d3f5211e96', '24');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FDRAGON%20BALL%20FighterZ%2F3.jpg?alt=media&token=47e03ae1-ea37-4c82-a801-28942869d69a', '24');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/oBI0MU73nlc" title="DRAGON BALL FighterZ - E3 2017 Trailer  | XB1, PS4, PC" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '24');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FForza%20Horizon%204%2F1.jpg?alt=media&token=f76f83fa-b2cf-44d2-a8e3-168f97b39613', '25');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FForza%20Horizon%204%2F2.jpg?alt=media&token=7e636db0-348f-4bbe-8d4d-ab88e913d102', '25');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FForza%20Horizon%204%2F3.jpg?alt=media&token=42f3769f-e907-43b1-906f-cf7ced4403bb', '25');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/DxXXnaHGaKs" title="Forza Horizon 4 - Steam Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '25');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGrand%20Theft%20Auto%20V%2F1.jpg?alt=media&token=d6505714-1359-4bab-b177-857c7f7cc435', '26');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGrand%20Theft%20Auto%20V%2F2.jpg?alt=media&token=152451c2-c905-42c9-b560-86fe13384e69', '26');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGrand%20Theft%20Auto%20V%2F3.jpg?alt=media&token=9751cc93-ecf7-49d5-a670-5402a3520394', '26');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/QkkoHAzjnUs" title="Grand Theft Auto V Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '26');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGunfire%20Reborn%2F1.jpg?alt=media&token=c4e1bd2c-417c-45f8-8c72-88843dd5d554', '27');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGunfire%20Reborn%2F2.jpg?alt=media&token=c6dc4c1f-ebfc-4e89-8477-c3000712a685', '27');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FGunfire%20Reborn%2F3.jpg?alt=media&token=f66afa47-1c45-4d2a-9ea1-ec00c88a0052', '27');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/v44FhFnOOK8" title="Gunfire Reborn - Multiplayer Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '27');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FHogwarts%20Legacy%2F1.jpg?alt=media&token=485e6d3d-9a11-4aa8-804f-7ad7de0d2be6', '28');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FHogwarts%20Legacy%2F2.jpg?alt=media&token=6f74890e-0464-45e7-a2a9-8c845b1a0c92', '28');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FHogwarts%20Legacy%2F3.jpg?alt=media&token=eb2fefb3-4316-4796-a043-87e4ac6d4d95', '28');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/1O6Qstncpnc" title="Hogwarts Legacy - Official Reveal Trailer | PS5" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '28');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMinecraft%20Dungeons%2F1.jpg?alt=media&token=562960f2-ef4a-439e-a5b6-c78cb85ae067', '29');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMinecraft%20Dungeons%2F2.jpg?alt=media&token=353a676e-11ea-4dd4-a10e-23c0b52abf1f', '29');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMinecraft%20Dungeons%2F3.jpg?alt=media&token=7f2d15ca-736c-4207-8680-379ae9b3cd4f', '29');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/df8oZ80hRH8" title="Minecraft Dungeons: Steam Launch Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '29');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMinecraft%20Legends%2F1.jpg?alt=media&token=ffa4cf5f-0f25-4bab-bc9d-98baa0df4551', '30');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMinecraft%20Legends%2F2.jpg?alt=media&token=f0474828-1657-4764-9b4f-e5a4fa206ac8', '30');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FMinecraft%20Legends%2F3.jpg?alt=media&token=9dccf61e-abaf-441d-b18a-caa8ca805fc3', '30');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/lw6f-tJKoao" title="Minecraft Legends: Official Gameplay Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '30');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FONE%20PIECE%20ODYSSEY%2F1.jpg?alt=media&token=3788dfba-da11-4561-a34c-e38bea5258cf', '31');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FONE%20PIECE%20ODYSSEY%2F2.jpg?alt=media&token=a6d127b6-1f01-40ec-9016-aae97856d32e', '31');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FONE%20PIECE%20ODYSSEY%2F3.jpg?alt=media&token=0a35f0f1-ab4e-4a13-859b-847935494d90', '31');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/bGok_Nr-yFs" title="ONE PIECE ODYSSEY | Full Memory Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '31');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FONE%20PIECE%20PIRATE%20WARRIORS%204%2F1.jpg?alt=media&token=f7e1281d-d54a-4451-8370-8119fbc42f5b', '32');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FONE%20PIECE%20PIRATE%20WARRIORS%204%2F2.jpg?alt=media&token=b4967a86-40cf-4ca1-98a9-40816b449450', '32');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FONE%20PIECE%20PIRATE%20WARRIORS%204%2F3.jpg?alt=media&token=3a6d6188-cd0d-4f68-bda7-5c45de29cac7', '32');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/Oe_vm7oCdIA" title="ONE PIECE: PIRATE WARRIORS 4 – Launch Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '32');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOri%20and%20the%20Blind%20Forest%2F1.jpg?alt=media&token=2adf6414-1942-4294-94f5-2b08638fecb6', '33');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOri%20and%20the%20Blind%20Forest%2F2.jpg?alt=media&token=9d4d1ff3-7c6c-4752-bee4-8018ab1a97b5', '33');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FOri%20and%20the%20Blind%20Forest%2F3.jpg?alt=media&token=a8d3960e-390d-44d5-8390-bc6aad35fe9b', '33');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/cklw-Yu3moE" title="Ori and the Blind Forest Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '33');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FReturn%20to%20Monkey%20Island%2F1.jpg?alt=media&token=ee7ab4e7-b8f7-4ef1-ac82-f45b484360d0', '34');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FReturn%20to%20Monkey%20Island%2F2.jpg?alt=media&token=2fee5a9b-0c75-43e0-8a87-720f2d7d9f29', '34');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FReturn%20to%20Monkey%20Island%2F3.jpg?alt=media&token=9acf1701-6934-4ec3-8167-6e9422206641', '34');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/p3mxq44HhnU" title="Return to Monkey Island | Gameplay Reveal Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '34');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FSTAR%20WARS%20Jedi%20Survivor%2F1.jpg?alt=media&token=6286834c-467d-4295-92b6-d3b2395863a9', '35');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FSTAR%20WARS%20Jedi%20Survivor%2F2.jpg?alt=media&token=1da94776-4b71-4bc3-a75f-104a3598be4a', '35');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FSTAR%20WARS%20Jedi%20Survivor%2F3.jpg?alt=media&token=2f413a4c-bbd3-4517-9247-facc125dd96c', '35');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/_F6YBwIPzmk" title="Star Wars Jedi: Survivor - Official Story Trailer" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '35');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Escapists%2F1.jpg?alt=media&token=6ae40b7f-fa59-49e8-9841-da67fc25a4fa', '36');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Escapists%2F2.jpg?alt=media&token=dff8830b-75a3-4560-adb0-4e423a09f213', '36');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Escapists%2F3.jpg?alt=media&token=0f6c472f-8f85-43f4-a9dd-bea0bb91beb3', '36');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/wpF3LFlXgSc" title="The Escapists: Gameplay Trailer [PC]" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '36');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Escapists%202%2F1.jpg?alt=media&token=79556da3-1367-4cb4-8138-276c1356a3f2', '37');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Escapists%202%2F2.jpg?alt=media&token=768d3c37-3e39-4552-b13a-6b100a2926ba', '37');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Escapists%202%2F3.jpg?alt=media&token=bfd1f2b8-e0b1-475e-91f6-81c5f9d71d1e', '37');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/AuqQEfOueSA" title="The Escapists 2 | Launch Trailer (Steam, PS4, Xbox One)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '37');

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('header', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Last%20Spell%2F1.jpg?alt=media&token=4e0dd4d4-b827-4cba-be69-e6f557a13630', '38');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Last%20Spell%2F2.jpg?alt=media&token=f485788b-115d-42e9-a1cf-db751783b6f4', '38');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('image', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Products%2FThe%20Last%20Spell%2F3.jpg?alt=media&token=108dcb6b-b8be-467d-a481-5045e34feed1', '38');
INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('video', '<iframe width="560" height="315" src="https://www.youtube.com/embed/Qi_kTd9xUoo" title="The Last Spell - Launch Trailer | PS5 &amp; PS4 Games" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>', '38');

SELECT * FROM PUBLIC.ProductDemos;