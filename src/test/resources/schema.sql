CREATE TABLE IF NOT EXISTS recipes (
                                       id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(255) NOT NULL,
                                       description VARCHAR(255) NOT NULL,
                                       serving INTEGER NOT NULL,
                                       instructions VARCHAR(255) NOT NULL,
                                       image VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS ingredients (
                                           id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                           name VARCHAR(255) NOT NULL,
                                           recipe_id INTEGER NOT NULL,
                                           quantity VARCHAR(255) NOT NULL,
                                           foreign key (recipe_id) references recipes(id)
);

CREATE TABLE IF NOT EXISTS categories (
                                          id INTEGER PRIMARY KEY AUTO_INCREMENT,
                                          name VARCHAR(255) NOT NULL,
                                          description VARCHAR(255) NOT NULL,
                                          recipe_id INTEGER NOT NULL,
                                          foreign key (recipe_id) references recipes(id)
);