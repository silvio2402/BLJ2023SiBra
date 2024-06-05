import { ExpandMore } from "@mui/icons-material";
import {
  Card,
  CardActions,
  CardContent,
  Collapse,
  IconButton,
  Rating,
  Skeleton,
  Stack,
  Typography,
  useTheme,
} from "@mui/material";
import { useState } from "react";
import { getModules, Module, useToken } from "./api";
import { useQuery } from "@tanstack/react-query";

interface ModulePreviewProps {
  module: Module;
  onRatingChange?: (rating: number | null) => void;
}

function ModulePreview({ module, onRatingChange }: ModulePreviewProps) {
  const theme = useTheme();
  const [expanded, setExpanded] = useState(false);

  return (
    <Card sx={{ minWidth: 100 }} elevation={3} key={module.beembk_modulid}>
      <CardContent sx={{ paddingBottom: 0 }}>
        <Typography variant="h6" component="h2">
          {module.beembk_modulnummer}
        </Typography>
        <Typography variant="body2">{module.beembk_modultitel}</Typography>
      </CardContent>
      <CardActions disableSpacing>
        <Rating
          value={3} // TODO
          onChange={(_, newValue) => onRatingChange && onRatingChange(newValue)}
        />
        <IconButton
          aria-label="show more"
          aria-expanded={expanded}
          sx={{
            marginLeft: "auto",
            transition: theme.transitions.create("transform", {
              duration: theme.transitions.duration.shortest,
            }),
            transform: !expanded ? "rotate(0deg)" : "rotate(180deg)",
          }}
          onClick={() => setExpanded((expanded) => !expanded)}
        >
          <ExpandMore />
        </IconButton>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography variant="body2" color="textSecondary">
            {module.beembk_objektbeschreibung}
          </Typography>
        </CardContent>
      </Collapse>
    </Card>
  );
}

interface ModuleListProps {
  selectedAbschluss: string | undefined;
}

function ModuleList({ selectedAbschluss }: ModuleListProps) {
  const token = useToken();

  const { data: modules, isPending } = useQuery({
    queryKey: ["modules"],
    queryFn: () => getModules(token!),
    enabled: !!token,
  });

  console.log(isPending);

  console.log(modules);

  return (
    <Stack spacing={2}>
      {!modules || isPending
        ? Array.from({ length: 8 }).map((_, index) => (
            <Skeleton key={index} variant="rectangular" height={100} />
          ))
        : modules.map((module) => (
            <ModulePreview
              key={module.beembk_modulnummer}
              module={module}
              // TODO
              // onRatingChange={(rating) => {
              //   setModules((modules) =>
              //     modules.map((m) =>
              //       m.id === module.id ? { ...m, rating } : m
              //     )
              //   );
              // }}
            />
          ))}
    </Stack>
  );
}

export default ModuleList;
