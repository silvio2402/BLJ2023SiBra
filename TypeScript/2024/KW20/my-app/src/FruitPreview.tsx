import React from "react";
import { Fruit } from "./types";
import {
  Box,
  Card,
  CardMedia,
  Typography,
  CardContent,
  CardActions,
  ButtonGroup,
  Button,
} from "@mui/material";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";

type FruitProp = Fruit & {
  count: number;
  onAdd: () => void;
  onRemove: () => void;
};

function FruitPreview({
  name,
  image,
  price,
  count,
  onAdd,
  onRemove,
}: FruitProp) {
  return (
    <Card sx={{ display: "flex" }}>
      <CardMedia component="img" image={image} sx={{ width: 151 }} />
      <Box sx={{ display: "flex", flexDirection: "column" }}>
        <CardContent sx={{ flex: "1 0 auto" }}>
          <Typography component="div" variant="h5">
            {name}
          </Typography>
          <Typography
            variant="subtitle1"
            color="text.secondary"
            component="div"
          >
            {price} CHF
          </Typography>
        </CardContent>
        <CardActions sx={{ justifyContent: "space-between" }}>
          <Typography variant="h6" component="div">
            {count}x
          </Typography>
          <ButtonGroup>
            <Button onClick={onAdd} size="small">
              <AddIcon />
            </Button>
            <Button onClick={onRemove} size="small">
              <RemoveIcon />
            </Button>
          </ButtonGroup>
        </CardActions>
      </Box>
    </Card>
  );
}

export default FruitPreview;
