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

SELECT * FROM PUBLIC.ProductDemos;