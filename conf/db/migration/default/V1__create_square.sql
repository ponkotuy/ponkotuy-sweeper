create table square(
    id uuid not null primary key,
    board_id uuid not null,
    x int not null,
    y int not null,
    bomb boolean not null,
    opened boolean not null
);

create unique index board_x_y on square(board_id, x, y);
