import { useEffect, useState } from "react";

export type QueryStatus = "pending" | "success" | "error";

type QueryState<T, S extends QueryStatus> = {
  status: S;
  fetching: boolean;
  data: S extends "success" ? T : T | null;
  error: S extends "error" ? unknown : null;
};

type QueryOptions<T> = {
  queryFn: () => Promise<T>;
  disable?: boolean;
};

export function useQuery<T>({ queryFn, disable }: QueryOptions<T>) {
  const [state, setState] = useState<QueryState<T, QueryStatus>>({
    status: "pending",
    fetching: false,
    data: null,
    error: null,
  });

  useEffect(() => {
    if (disable) return;
    if (state.fetching) return;
    if (state.status !== "pending") return;

    setState((state) => ({
      ...state,
      status: "pending",
      fetching: true,
      error: null,
    }));

    queryFn()
      .then((data) =>
        setState((state) => ({
          ...state,
          status: "success",
          fetching: false,
          data,
          error: null,
        }))
      )
      .catch((error) =>
        setState((state) => ({
          ...state,
          status: "error",
          fetching: false,
          data: null,
          error,
        }))
      );
  }, [queryFn, disable, state.fetching, state.status]);

  return state;
}
