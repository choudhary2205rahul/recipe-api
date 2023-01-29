INSERT INTO recipes (name, description, instructions, image, serving)
VALUES ('Pancakes','Delicious pancakes', 'Mix all ingredients together and cook on a pan.', 'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png', 4);

INSERT INTO ingredients (name, recipe_id, quantity) VALUES ('Flour', 1, '1 cup');

INSERT INTO categories (name,description,recipe_id) VALUES ('Breakfast', 'Breakfast recipes', 1);

