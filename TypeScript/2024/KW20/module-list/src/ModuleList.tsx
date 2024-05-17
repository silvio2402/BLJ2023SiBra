import {
  Card,
  CardActions,
  CardContent,
  Rating,
  Stack,
  Typography,
} from "@mui/material";
import { useState } from "react";

type Module = {
  id: number;
  title: string;
  rating: number;
};

function ModuleList() {
  const [modules, setModules] = useState<Module[]>([
    {
      id: 117,
      title:
        "Informatik- und Netzinfrastruktur für ein kleines Unternehmen realisieren",
      rating: 0,
    },
    {
      id: 122,
      title: "Abläufe mit einer Scriptsprache automatisieren",
      rating: 0,
    },
    { id: 162, title: "Daten analysieren und modellieren", rating: 0 },
    { id: 164, title: "Datenbanken erstellen und Daten einfügen", rating: 0 },
    { id: 231, title: "Datenschutz und Datensicherheit anwenden", rating: 0 },
    { id: 293, title: "Webauftritt erstellen und veröffentlichen", rating: 0 },
    { id: 319, title: "Applikationen entwerfen und implementieren", rating: 0 },
    {
      id: 431,
      title: "Aufträge im eigenen Berufsumfeld selbstständig durchführen",
      rating: 0,
    },
  ]);

  return (
    <Stack spacing={2}>
      {modules.map((module) => (
        <Card sx={{ minWidth: 100 }}>
          <CardContent sx={{ paddingBottom: 0 }}>
            <Typography variant="h6" component="h2">
              {module.id}
            </Typography>
            <Typography variant="body2">{module.title}</Typography>
          </CardContent>
          <CardActions>
            <Rating
              value={module.rating}
              onChange={(_, newValue) => {
                if (newValue === null) return;
                setModules((modules) =>
                  modules.map((m) =>
                    m.id === module.id ? { ...m, rating: newValue } : m
                  )
                );
              }}
            />
          </CardActions>
        </Card>
      ))}
    </Stack>
  );
}

export default ModuleList;
